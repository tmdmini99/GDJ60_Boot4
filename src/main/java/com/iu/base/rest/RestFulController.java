package com.iu.base.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iu.base.board.BoardFileVO;
import com.iu.base.board.BoardVO;
import com.iu.base.board.notice.NoticeController;
import com.iu.base.board.notice.NoticeService;
import com.iu.base.util.Pager;


import lombok.extern.slf4j.Slf4j;

@Slf4j
//controller의 모든 매서드가 @responsebody가 필요하다면 
@RestController
public class RestFulController {

   @Autowired
   private NoticeService noticeService;
   
   @ResponseBody
   @GetMapping("/rest/detail")
   public BoardVO getDetail(BoardVO boardVO) throws Exception{
       boardVO = noticeService.getDetail(boardVO);
      return boardVO;
   }
   
   @DeleteMapping("/rest/list/{page}")
   @ResponseBody
   public List<BoardVO> getList(@PathVariable(name = "page" ,value= "1",required = false) Long p, Pager pager) throws Exception {
      
      ModelAndView mv = new ModelAndView();
      log.error("{}::::::::::::::::::::::::",p);
      List<BoardVO> ar = noticeService.getList(pager);
      mv.addObject("list",ar);
      mv.setViewName("board/list");
      return ar;   
   }
}