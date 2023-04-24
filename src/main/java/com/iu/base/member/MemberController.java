package com.iu.base.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.base.board.BoardVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	
	
	
	@GetMapping("admin")
	public void getAdmin() throws Exception{
		
	}
	
	@GetMapping("mypage")
	public void getMyPage() throws Exception{
		
	}
	
	
	
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
	public ModelAndView getMemberJoin(@ModelAttribute MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join");
		return mv;
	}
	@PostMapping("join")
	public ModelAndView getMemberJoin(@Valid MemberVO memberVO,BindingResult bindingResult) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boolean check = memberService.memberCheck(memberVO, bindingResult);
		
		if(check) {
			log.warn("========검증 실패===========");
			mv.setViewName("member/join");
			return mv;
		}
		
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
	@GetMapping("idDuplicateCheck")
	@ResponseBody
	public boolean idDuplicateCheck(MemberVO memberVO) throws Exception{
		
		log.error("ID 중복 체크");
		int result = memberService.getIdCheck(memberVO);
		boolean check = true;	
		if(result ==1) {
				check = false;
			}
		return check;
		
	}
}
