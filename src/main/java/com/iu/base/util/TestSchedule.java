package com.iu.base.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iu.base.board.notice.NoticeDAO;
import com.iu.base.board.notice.NoticeVO;
import com.iu.base.member.MemberDAO;

import com.iu.base.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestSchedule {
   @Autowired
   private MemberDAO memberDAO;
   
   @Autowired
   private NoticeDAO noticeDAO;
   
   @Autowired
   private Mail mail;
	
   @Scheduled(cron = "*/10 * * * * *")
   public void test() throws Exception{
	   
	   //방법 1
	   
//      log.error("========================반복 =====================");
//      for(MemberVO memberVO : memberDAO.getMemberList()) {
//    	  int result = memberDAO.getLogoutTime(memberVO);
//    	  log.error("====={}===",result);
//    	  
//    	  if(result >= 3) {
//    		  if(!memberVO.isEnabled()) {
//    			  continue;
//    		  }
//    		  memberDAO.setEnable(memberVO);
//    	  }
//    	  log.error("====={}===",memberVO.getUserName());
//      }
	   
	   //방법 2
	   
//	   log.error("========================반복 =====================");
//	      for(MemberVO memberVO : memberDAO.getMemberList()) {
//	    	  int result = memberDAO.setEnables(memberVO);
//	    	  log.error("====={}===",result);
//	    	  
//	    	  
//	    	  log.error("====={}===",memberVO.getUserName());
//	      }
	   
	   List<MemberVO> ar = memberDAO.getBirth();
	   log.error("==========실행=======");
	   if(noticeDAO.getCount() <1) {
	   mail.sendMail();
		NoticeVO noticeVO = new NoticeVO();
	   noticeVO.setTitle("오늘의 생일");
	   noticeVO.setWriter("관리자");
	   noticeVO.setContents(" 생일입니다");
	   
	   for(MemberVO memberVO : ar){
		   noticeVO.setContents(memberVO.getName()+","+noticeVO.getContents());
	   }
	   int result=noticeDAO.setInsert(noticeVO);
	   if(result == 1) {
		   log.error("==========성공=======");
	   }
	   
	   }
	   log.error("==========끝=======");
   }
}