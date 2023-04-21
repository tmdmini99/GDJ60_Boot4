package com.iu.base.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iu.base.member.MemberVO;
import com.iu.base.member.RoleVO;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author GDJ60
 * 로그인 유무를 판단하는 Interceptor
 *
 */


@Slf4j
@Component
public class AdminCheckInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		log.info("===================Interceptor 실행admin================");
		HttpSession session = request.getSession();
		MemberVO memberVO=(MemberVO)session.getAttribute("member");
		log.error(request.getRequestURI());
		String a=request.getRequestURI();
		
			
			log.error("Interceptor 실행 admin");
			for(RoleVO roleVO : memberVO.getRoleVOs()) {
				if(roleVO.getNum() ==1L) {
					return true;
				}
				
			}
		
			
			//redirect
			//response.sendRedirect("/member/login");
			
			//forwarding
			request.setAttribute("message", "권한 필요");
			request.setAttribute("url","/");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			return false;
		
		
		
		
	}
	
	
}
