package com.iu.base.board.notice;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.iu.base.board.BoardVO;

@SpringBootTest
@Rollback(true)
public class NoticeDAOTest {

   @Autowired
   private NoticeDAO noticeDAO;
   
   //@Test
   void setInsertTest()throws Exception{
      
	   for(int i=0; i<120; i++) {
		   
	   
	   BoardVO boardVO = new NoticeVO();
      boardVO.setWriter("id");
      boardVO.setTitle("inesrtTest");
      boardVO.setContents("insertTest Contetns");
      
      int result = noticeDAO.setInsert(boardVO);
      if(i%10==0) {
    	  Thread.sleep(500);
      }
	   }
      System.out.println("End");
      
      
   }
   
   @Test
   void getDetailTest()throws Exception{
      BoardVO boardVO = new NoticeVO();
      boardVO.setNum(2L);
      
       boardVO= noticeDAO.getDetail(boardVO);
      assertNotNull(boardVO);
      
      
   }
   //@Test
//   void getListTest()throws Exception{
//	      BoardVO boardVO = new NoticeVO();
//	      
//	      
//	       List<BoardVO>ar = noticeDAO.getList();
//	      assertNotNull(ar);
//	      
//	      
//	   }
   //@Test
   void getCountTest()throws Exception{
      Long count = noticeDAO.getTotalCount();
      System.out.println(count);
      assertNotNull(count);
   }
   
}