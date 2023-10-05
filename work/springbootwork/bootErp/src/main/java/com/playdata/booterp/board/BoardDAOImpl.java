package com.playdata.booterp.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playdata.booterp.dto.BoardDTO;
import com.playdata.booterp.dto.BoardFileDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	// MyBatis의 핵심 클래스를 이용해서 sql 문을 작성
	SqlSession sqlSessionTemplate;
	
	@Autowired
	public BoardDAOImpl(SqlSession sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int insert(BoardDTO board) {
		// mybatis의 insert 메소드 내부에서 BoardDTO 객체의 getter 메소드를 호출해서 데이터를 꺼내서 
		return sqlSessionTemplate.insert("com.playdata.erp.board.insert", board);
	}

	// mapper 파일에 정의된
	// namespace + id가 sql문을 찾는 키가 된다.
	// com.playdata.erp.board.selectall
	@Override
	public List<BoardDTO> boardList() {
		return sqlSessionTemplate.selectList("com.playdata.erp.board.selectall");
	}

	@Override
	public BoardDTO read(String board_no) {
		return sqlSessionTemplate.selectOne("com.playdata.erp.board.read", board_no);
	}

	@Override
	public int update(BoardDTO board) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("com.playdata.erp.board.update", board);
	}

	@Override
	public int delete(String board_no) {
		return sqlSessionTemplate.delete("com.playdata.erp.board.delete", board_no);
	}

	@Override
	public List<BoardDTO> search(String data) {
		Map param = new HashMap();
		param.put("data" , data);
		return sqlSessionTemplate.selectList("com.playdata.erp.board.search", param);
	}

	@Override
	public List<BoardDTO> search(String tag, String data) {
		Map<String, String> param = new HashMap();
		param.put("tag" , tag);
		param.put("data" , data);
		return sqlSessionTemplate.selectList("com.playdata.erp.board.dynamicSearch", param);
	}

	@Override
	public List<BoardDTO> findByCategory(String category) {
		return sqlSessionTemplate.selectList("com.playdata.erp.board.categorySelect", category);
	}

	@Override
	public int insertFile(List<BoardFileDTO> boardfiledtolist) {
		return sqlSessionTemplate.insert("com.playdata.erp.board.fileinsert", boardfiledtolist);
	}

	@Override
	public List<BoardFileDTO> getFileList(String boardno) {
		return sqlSessionTemplate.selectList("com.playdata.erp.board.fileselect", boardno);
	}

}
