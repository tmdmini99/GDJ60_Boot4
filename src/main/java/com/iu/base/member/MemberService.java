package com.iu.base.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor=Exception.class)
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
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
			if(result == 1) {
				result=memberDAO.setRoleInsert(memberVO);
			}
		return result;
	}
}
