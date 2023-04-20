package com.iu.base.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
