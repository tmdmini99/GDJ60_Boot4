package com.iu.base.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {

	//public List<MemberVO> setMemberLogin(MemberVO memberVO) throws Exception;
	public MemberVO setMemberLogin(MemberVO memberVO) throws Exception;
	
	
	public int setMemberInsert(MemberVO memberVO)throws Exception;
	
	public int setRoleInsert(MemberVO memberVO);
	
	public MemberVO getIdCheck(MemberVO memberVO) throws Exception;

	public int setMemberRole(Map<String, Object> map);
	
	public List<MemberVO> getMemberList() throws Exception;
	
	public int setLogout(MemberVO memberVO) throws Exception;
	
	public int getLogoutTime(MemberVO memberVO)throws Exception;
	
	public int setEnable(MemberVO memberVO) throws Exception;
	
	public int setEnables(MemberVO memberVO) throws Exception;
	
	public int setEnabless(MemberVO memberVO) throws Exception;
	
	public List<MemberVO> getBirth() throws Exception;
	
	public int setPwChange(MemberVO memberVO) throws Exception;
	
	
	
	public MemberVO getEmailCheck(MemberVO memberVO) throws Exception;
}
