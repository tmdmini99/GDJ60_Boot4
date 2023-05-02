package com.iu.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.iu.base.member.MemberService;
import com.iu.base.member.MemberSocialService;
import com.iu.base.security.UserLoginFailHandler;
import com.iu.base.security.UserLogoutHandler;
import com.iu.base.security.UserLogoutSuccessHandler;
import com.iu.base.security.UserSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private MemberSocialService memberSocialService;
	
	@Autowired
	private UserLogoutSuccessHandler logoutSuccessHandler;
	
	@Autowired
	private UserSuccessHandler userSuccessHandler;
	
	
	@Autowired
	private UserLogoutHandler userLogoutHandler;
	@Bean
	WebSecurityCustomizer wegSecurityConfig() {
		
		//Security에서 무시해야하는 URL 패턴 등록
		return web ->web
					.ignoring()
					.antMatchers("/images/**")
					.antMatchers("/js/**")
					.antMatchers("/css/**")
					.antMatchers("/favicon/**");
	}
	@Bean
	SecurityFilterChain fiterChain(HttpSecurity httpSecurity)throws Exception{
		httpSecurity
		.cors()
		.and()
		.csrf()
		.disable()
		.authorizeRequests()
		//url과 권한 매칭
			.antMatchers("/").permitAll()
			.antMatchers("/member/join").permitAll()
			.antMatchers("/notice/add").hasRole("ADMIN")
			.antMatchers("/notice/update").hasRole("ADMIN")
			.antMatchers("/notice/delete").hasRole("ADMIN")
			.antMatchers("/notice/*").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/qna/add").hasAnyRole("ADMIN","MANAGER","MEMBER")
			//.anyRequest().authenticated()
			//.anyRequest().permitAll()
			.and()
			.formLogin()
				.loginPage("/member/login")
				//.usernameParameter("userName")  //id 파라미터는 username이지만, 개발자가 다른 파라미터 이름을 사용할 때
				//.defaultSuccessUrl("/")  //인증에 성공할 경우 요청할 URL
				.successHandler(userSuccessHandler)
				//.failureUrl("/member/login")
				.failureHandler(new UserLoginFailHandler())
				.permitAll().and()
			.logout()
				.logoutUrl("/member/logout")
				//.logoutSuccessUrl("/")
				//.addLogoutHandler(userLogoutHandler)
				.logoutSuccessHandler(logoutSuccessHandler)
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.permitAll()
				.and()
//				.sessionManagement()
//					.maximumSessions(1)//허용가능한 session 수, -1: 무제한
//					.maxSessionsPreventsLogin(false)//false : 이전 사용자 세션 만료  true : 새로운 사용자 인증 실패
				//.and()
				.oauth2Login()
					.userInfoEndpoint()
					.userService(memberSocialService)
			;
		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
