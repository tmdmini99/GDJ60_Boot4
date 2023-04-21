package com.iu.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.base.interceptors.AdminCheckInterceptor;
import com.iu.base.interceptors.MemberCheckInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private MemberCheckInterceptor memberCheckInterceptor;
	
	@Autowired
	private AdminCheckInterceptor adminCheckInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(memberCheckInterceptor)
				.addPathPatterns("/member/*")
				.addPathPatterns("/qna/*")
				.addPathPatterns("/qna/add")
				.excludePathPatterns("/qna/list")
				.addPathPatterns("/member/admin")
				.excludePathPatterns("/member/login")
				.addPathPatterns("/notice/*")
				.excludePathPatterns("/notice/list")
				.excludePathPatterns("/notice/detail")
				;
		registry.addInterceptor(adminCheckInterceptor)
				.addPathPatterns("/member/admin")
				.addPathPatterns("/notice/*")
				.excludePathPatterns("/notice/list")
				.excludePathPatterns("/notice/detail");
	
		
	}
	
	
	
	
}