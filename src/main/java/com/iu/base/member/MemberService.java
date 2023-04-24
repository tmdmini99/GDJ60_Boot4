package com.iu.base.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Service
@Transactional(rollbackFor=Exception.class)
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	
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
		if(memberDAO.setMemberLogin(memberVO) != null && memberVO.getUserName().equals(memberDAO.setMemberLogin(memberVO).getUserName())) {
			result = true;
			bindingResult.rejectValue("userName", "member.id.eq");
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
		
		int result=memberDAO.setMemberInsert(memberVO);
			Map<String, Object> map = new HashMap<>();
			map.put("userName", memberVO.getUserName());
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
}
