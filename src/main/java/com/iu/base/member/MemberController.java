package com.iu.base.member;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.iu.base.board.BoardVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
	private String adminKey;
	
	
	@GetMapping("delete")
	public String delete()throws Exception{
		MemberVO memberVO=(MemberVO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//회원가입 방법 구분
		this.kakaoDelete(memberVO);
		
		return "redirect:./logout";
		
	}
	
	private void kakaoDelete(MemberVO memberVO)throws Exception{
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", " KakaoAK "+adminKey);
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		
		params.add("target_id_type", "user_id");
		params.add("target_id", memberVO.getAttributes().get("id").toString());
		
		HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<>(params,headers);
		
		String id=restTemplate.postForObject("https://kapi.kakao.com/v1/user/unlink", req, String.class);
		
		log.error("Delete {} ::::",id);		
	}
	
	@GetMapping("info")
	public void info(HttpSession httpSession) {
		String pw = "user3";
		MemberVO memberVO=(MemberVO)memberService.loadUserByUsername("user3");
		log.error("============== {}===============",memberVO.getPassword());
		log.error("============== {}===============",passwordEncoder.encode(pw));
		
		//내가 입력한 pw와 db에 저장된 pw로 비교 할시 matches를 이용하여 비교
		boolean check=passwordEncoder.matches(pw, memberVO.getPassword());
		log.error("============== {}===============",check);
		
		log.error("==============login Info===============");
		//SPRING_SECURITY_CONTEXT
//		Enumeration<String> names=httpSession.getAttributeNames();
//		while (names.hasMoreElements()) {
//			log.error("=============={}===============",names.nextElement());
//			
//		}
		Object obj=httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		SecurityContextImpl contextImpl= (SecurityContextImpl)obj;
		Authentication authentication=contextImpl.getAuthentication();
		
		log.error("=========={}=======",obj);
		log.error("==========NAME : {}=======",authentication.getName());
		log.error("==========DETAILS : {}=======",authentication.getDetails());
		log.error("==========MemberVO : {}=======",authentication.getPrincipal());
	}
	
	
	@GetMapping("admin")
	public void getAdmin() throws Exception{
		
	}
	
	@GetMapping("mypage")
	public void getMyPage() throws Exception{
		
	}
	
	
	
	@GetMapping("login")
	public ModelAndView getMemberLogin(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		Object obj=session.getAttribute("SPRING_SECURITY_CONTEXT");
		
		if(obj==null) {
		mv.setViewName("member/login");
}else {
	mv.setViewName("redirect:/");
}
		return mv;
	}
//	@PostMapping("login")
//	public ModelAndView getMemberLogin(MemberVO memberVO,HttpSession session) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		memberVO=memberService.setMemberLogin(memberVO);
//		mv.setViewName("redirect:./login");
//		if(memberVO !=null) {
//			session.setAttribute("member", memberVO);
//			mv.setViewName("redirect:/");
//		}
//		return mv;
//	}
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
//	@GetMapping("socialLogout")
//	public ModelAndView getMemberLogout(HttpSession session) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		MemberVO memberVO =(MemberVO)session.getAttribute("member");
//		int result = memberService.setLogout(memberVO);
//		session.invalidate();
//		mv.setViewName("redirect:/");
//		return mv;
//	}
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
	@GetMapping("findPassword")
	public ModelAndView setFindPassword(@ModelAttribute MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/findPw");
		return mv;
	}
	@PostMapping("findPassword")
	public ModelAndView setFindPassword(@Valid MemberVO memberVO,BindingResult bindingResult) throws Exception{
		ModelAndView mv = new ModelAndView();
		boolean result =memberService.setPwChange(memberVO,bindingResult);
		if(!result) {
			mv.addObject("check", 1);
		}
		mv.setViewName("member/findPw");
		return mv;
	}
}
