package com.iu.base.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iu.base.board.BoardDAO;
import com.iu.base.board.BoardVO;
import com.iu.base.util.Pager;

@Mapper
public interface QnaDAO extends BoardDAO{
	
	
	public int setRefUpdate(BoardVO boardVO)throws Exception;
	
	public List<QnaVO> getLists(Pager pager) throws Exception;
	
	public BoardVO getDetail(BoardVO boardVO) throws Exception;
}
