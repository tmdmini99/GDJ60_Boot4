package com.iu.base.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("login")
	public ModelAndView getMemberLogin() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		return mv;
	}
	@PostMapping("login")
	public ModelAndView getMemberLogin(MemberVO memberVO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO=memberService.setMemberLogin(memberVO);
		mv.setViewName("redirect:./login");
		if(memberVO !=null) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	@GetMapping("join")
	public ModelAndView getMemberJoin() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join");
		return mv;
	}
	@PostMapping("join")
	public ModelAndView getMemberJoin(MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int reuslt = memberService.setMemberInsert(memberVO);
		mv.setViewName("redirect:./login");
		return mv;
	}
	@GetMapping("logout")
	public ModelAndView getMemberLogout(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.setViewName("redirect:/");
		return mv;
	}
}
