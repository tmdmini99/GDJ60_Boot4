package com.iu.base.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.iu.base.util.Mail;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor=Exception.class)
@Slf4j
public class MemberService implements UserDetailsService {
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private Mail mail;
	
	
	
	
	


	//패스워드가 일치하는지 검증하는 메서드
	public boolean memberCheck(MemberVO memberVO, BindingResult bindingResult) throws Exception{
		boolean result=false;
		//false : error가 없음,검증 성공
		//true : error가 실패, 검증 실패
		//1. annotation 검증 결과
		result=bindingResult.hasErrors();
		
		if(!memberVO.getPassword().equals(memberVO.getPasswordCheck())) {
			result = true;
			bindingResult.rejectValue("passwordCheck", "member.password.notEqual");
		}
		//3. ID 중복검사
		if(memberDAO.setMemberLogin(memberVO) != null && memberVO.getUsername().equals(memberDAO.setMemberLogin(memberVO).getUsername())) {
			result = true;
			bindingResult.rejectValue("username", "member.id.eq");
		}
		
		return result;
	}
	
	
	public MemberVO setMemberLogin(MemberVO memberVO) throws Exception{
//		 List<MemberVO> memberVO2=memberDAO.setMemberLogin(memberVO);
//		if(memberVO2 !=null && memberVO.getPassword().equals(memberVO2.get(0).getPassword())) {
//			memberVO.setPassword(null);
//			
//			for(int i=0; i<memberVO2.size(); i++) {
//				if(i+1<memberVO2.size()) {
//					if(memberVO2.get(i).getRoleVO().getNum()< memberVO2.get(i+1).getRoleVO().getNum()) {
//						memberVO.setRoleVO(memberVO2.get(i).getRoleVO());
//					}
//	
//				}else {
//					continue;
//				}
//			}
//		}
		MemberVO memberVO2 = memberDAO.setMemberLogin(memberVO);
		if(memberVO2 !=null && memberVO.getPassword().equals(memberVO2.getPassword())) {
			memberVO.setPassword(null);
			memberVO.setRoleVOs(memberVO2.getRoleVOs());
		}
		return memberVO;
	}
	public int setMemberInsert(MemberVO memberVO)throws Exception{
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
		
		int result=memberDAO.setMemberInsert(memberVO);
			Map<String, Object> map = new HashMap<>();
			map.put("username", memberVO.getUsername());
			map.put("num", 3);
			result = memberDAO.setMemberRole(map);
		return result;
	}
	public int getIdCheck(MemberVO memberVO) throws Exception{
		memberVO = memberDAO.getIdCheck(memberVO);
		int result = 0;
		if(memberVO != null) {
			result = 1;
		}
		return result;
	}
	public int setLogout(MemberVO memberVO) throws Exception{
		return memberDAO.setLogout(memberVO);
	}
	public int getLogoutTime(MemberVO memberVO)throws Exception{
		int result = memberDAO.getLogoutTime(memberVO);
		return result;
	}
	
	public int setEnable(MemberVO memberVO) throws Exception{
		return memberDAO.setEnable(memberVO);
	}
	public List<MemberVO> getBirth() throws Exception{
		return memberDAO.getBirth();
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		log.error("===================Spring Security Login ===========");
		log.error("=================== {} ===========",username);
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername(username);
		try {
			memberVO=memberDAO.setMemberLogin(memberVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberVO;
	}
	public boolean setPwChange(MemberVO memberVO, BindingResult bindingResult) throws Exception{
		boolean result = false;
		MemberVO memberVO2 = new MemberVO();
		
		memberVO2 = memberDAO.getIdCheck(memberVO);
		if(memberVO2 == null) {
			result = true;
			bindingResult.rejectValue("username", "member.username.notEqual");
			
		}
		memberVO2 = memberDAO.getEmailCheck(memberVO);
		if(memberVO2 == null) {
			result = true;
			bindingResult.rejectValue("email", "member.email.notEqual");
		}
		if(memberVO2 != null) {
		
		int leftLimit = 48; // numeral '0'
		 int rightLimit = 122; // letter 'z'
		 int targetStringLength = 6;
		 Random random = new Random();
		 String generatedString = random.ints(leftLimit, rightLimit + 1)
		                                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		                                .limit(targetStringLength)
		                                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		                                .toString();
		 memberVO.setPassword(generatedString);
		 mail.sendMail(memberVO);
		 memberVO.setPassword(passwordEncoder.encode(generatedString));
		  memberDAO.setPwChange(memberVO);
		}
        return result;
	}
	
	
	
}
