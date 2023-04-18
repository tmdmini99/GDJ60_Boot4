package com.iu.base.board;

import java.util.List;

import com.iu.base.util.Pager;

public interface BoardDAO {
	
	
	
	 //글 갯수
	public Long getTotalCount() throws Exception;
	 
		
	
	
	
	
	 //글리스트 조회 
	public List< BoardVO> getList(Pager pager) throws Exception;
	 
	
	

//	
	//글하나 조회
	public BoardVO getDetail(BoardVO boardVO) throws Exception;
	
	
	
	 //글쓰기 
	public int setInsert(BoardVO boardVO)throws Exception;
	 
		
	
	//글 수정
	public int setUpdate(BoardVO boardVO)throws Exception;
		
	
	//글 삭제
	public int setDelete(BoardVO boardVO)throws Exception;
		
	
}
