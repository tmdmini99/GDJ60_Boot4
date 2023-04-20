package com.iu.base.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.base.board.BoardFileVO;
import com.iu.base.board.BoardService;
import com.iu.base.board.BoardVO;
import com.iu.base.util.Pager;

@Service
@Transactional(rollbackFor=Exception.class)
public class QnaService implements BoardService{

	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeNum(qnaDAO.getTotalCount());
		pager.makeStartRow();
		return qnaDAO.getList(pager);
	}
	
	public List<QnaVO> getLists(Pager pager) throws Exception {
		pager.makeNum(qnaDAO.getTotalCount());
		pager.makeStartRow();
		return qnaDAO.getLists(pager);
	}

	@Override
	public BoardVO getDetail(BoardVO boardVO) throws Exception {
		
		return qnaDAO.getDetail(boardVO);
	}

	@Override
	public int setInsert(BoardVO boardVO, MultipartFile[] multipartFiles) throws Exception {
		return qnaDAO.setInsert(boardVO);
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardFileVO getFileDetail(BoardFileVO boardFileVO) throws Exception {
		
		return qnaDAO.getFileDetail(boardFileVO);
	}

	
	
}
