package com.playdata.booterp.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playdata.booterp.dto.BoardDTO;
import com.playdata.booterp.dto.BoardFileDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
	BoardDAO dao;
	
	@Autowired
	public BoardServiceImpl(BoardDAO dao) {
		super();
		this.dao = dao;
	}

	// 게시글 등록 버튼을 눌렀을때 실행될 메소드
	// - 두개의 작업을 처리
	// - tbboard테이블에 글에 대한 일반적인 내용을 저장, board_file테이블에 첨부된 파일의 정보를 저장
	// - 서비스 메소드 한개에서 dao메소드 두개를 호출해야 한다.
	// - 서비스 메소드에 호출되는 두개의 메소드가 모두 정상처리 되어야 db에 모든 내용을 반영할 수 있도록 처리해야 함
	// - 만약 두 작업중 하나의 작업만 처리되고 오류가 발생하면 진행된 작업이 모두 취소되도록 처리해아 한다.
	// =============> 트렌젝션 처리를 반드시 해야한다.
	
	@Override
	public int insert(BoardDTO board, List<BoardFileDTO> boardfiledtolist) {
		dao.insert(board);
		dao.insertFile(boardfiledtolist);
		return 0;
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

	@Override
	public List<BoardFileDTO> getFileList(String boardno) {
		return dao.getFileList(boardno);
	}

}
