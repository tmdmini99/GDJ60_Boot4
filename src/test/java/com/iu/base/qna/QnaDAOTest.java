package com.iu.base.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.iu.base.board.BoardVO;
import com.iu.base.board.qna.QnaDAO;
import com.iu.base.board.qna.QnaVO;
import com.iu.base.util.Pager;

@SpringBootTest
class QnaDAOTest {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	void setInsertTest()  throws Exception{
		QnaVO qnaVO = new QnaVO();
		qnaVO.setTitle("insertssSSSeeeesssssssssss");
		qnaVO.setContents("contents");
		qnaVO.setWriter("wrtier");
		int result = qnaDAO.setInsert(qnaVO);
		qnaVO.setRef(qnaVO.getNum());
		result = qnaDAO.setRefUpdate(qnaVO);
		
		assertEquals(1,result);
	}

	//@Test
	void getListTest()  throws Exception{
		QnaVO qnaVO = new QnaVO();
		qnaVO.setNum(1L);
		Pager pager = new Pager();
		pager.makeNum(qnaDAO.getTotalCount());
		pager.makeStartRow();
		List<BoardVO> ar = qnaDAO.getList(pager);
		
		assertNotNull(ar);
	}
	//@Test
	void getDetailTest()  throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(1L);
		
		
		boardVO= qnaDAO.getDetail(boardVO);
		
		assertNotNull(boardVO);
	}

}
