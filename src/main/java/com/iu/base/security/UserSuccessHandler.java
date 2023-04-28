package com.iu.base.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class UserSuccessHandler implements AuthenticationSuccessHandler{
	
	
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.error("========= Login 성공후 실행========");
		log.error("========= {}========",authentication.getPrincipal());
		if(request.getParameter("remember") !=null) {
		
			Cookie cookie = new Cookie("remember", authentication.getName());
			cookie.setMaxAge(60*60*24*7);
			response.addCookie(cookie);
			
		}else {
			Cookie [] cookies=request.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("remember")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
			 
			
		}
		//foward
//		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
//		view.forward(request,response);
//		
		//redirect
		response.sendRedirect("/");
	}

	
}
