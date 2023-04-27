package com.iu.base.member;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO implements UserDetails{
	
	
	
	

	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
	private String passwordCheck;
	
	@NotBlank
	private String name;
	@Email
	private String email;
	@Past
	private Date birth;
	

	private RoleVO roleVO;
	private List<RoleVO> roleVOs;
	
	private Date lastTime;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RoleVO roleVO : roleVOs) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}
		return authorities;
	}

//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
	//username(id) 반환
//		return null;
//	}
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
	//password 반환
//		return null;
//	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		//계정 만료 여부
		// true : 만료 안됨
		//false : 만료 됨 로그인 안됨
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		//계정의 잠김 여부
		// true : 잠기지 않음
		//false : 잠김 로그인 안됨
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		//password 만료 여부
		// true : 만료 안됨
		//false : 만료 됨 로그인 안됨
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		//계정 사용 여부
		// true : 계정 활성화
		//false : 계정 비활성화 로그인 안됨
		return true;
	}
}
