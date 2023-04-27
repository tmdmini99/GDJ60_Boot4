package com.iu.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
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
				.defaultSuccessUrl("/")  //인증에 성공할 경우 요청할 URL
				.failureUrl("/member/login")
				.permitAll().and()
			.logout()
				.logoutUrl("member/logout")
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
				.deleteCookies("JJSESSIONID")
				.permitAll()

			;
		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
