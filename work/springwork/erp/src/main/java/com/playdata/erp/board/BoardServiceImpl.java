package com.playdata.erp.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	BoardDAO dao;
	
	@Autowired
	public BoardServiceImpl(BoardDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public int insert(BoardDTO board) {
		return dao.insert(board);
	}

	@Override
	public List<BoardDTO> boardList() {
		return dao.boardList();
	}

	// 전체 게시글 조회와 카테고리별 조회를 하나의 서비스 메소드에서 처리하기
	@Override
	public List<BoardDTO> findByCategory(String category) {
		List<BoardDTO> list = null;
		if (category != null) {
			if (category.equals("all")) {
				list = dao.boardList();
			} else {
				list = dao.findByCategory(category);
			}
		}
		return list;
	}

	@Override
	public BoardDTO getBoardInfo(String board_no) {
		System.out.println("service " + board_no);
		return dao.read(board_no);
	}

	@Override
	public int update(BoardDTO board) {
		return dao.update(board);
	}

	@Override
	public int delete(String board_no) {
		return dao.delete(board_no);
	}

	@Override
	public List<BoardDTO> search(String data) {
		return dao.search(data);
	}

	@Override
	public List<BoardDTO> search(String tag, String data) {
		return dao.search(tag, data);
	}

}
