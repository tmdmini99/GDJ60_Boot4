package com.iu.base.board.qna;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.base.board.BoardVO;
import com.iu.base.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/qna/*")
@Slf4j
public class QnaController {
	
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	
	@GetMapping("list")
	public ModelAndView getQnaList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardVO> ar = qnaService.getList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		return mv;
	}
	@GetMapping("detail")
	public ModelAndView getQnaDetail(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@GetMapping("add")
	public ModelAndView setInsert(@ModelAttribute BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/add");
		//mv.addObject(new NoticeVO());//속성명은 클래스명의 첫글자를 소문자로 바꾼것
		return mv;
	}
	@PostMapping("add")
	public ModelAndView setInsert(@Valid BoardVO boardVO,BindingResult bindingResult ,MultipartFile [] boardFiles) throws Exception{
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()) {
			log.warn("========검증 실패===========");
			mv.setViewName("board/add");
			return mv;
		}
		
		//int result = noticeService.setInsert(noticeVO,boardFiles);
		for(MultipartFile multipartFile : boardFiles) {
			log.info("OriginalName : {} Size : {}",multipartFile.getOriginalFilename(),multipartFile.getSize());
		}
		
		mv.setViewName("redirect:./list");
		return mv;
	}
}
