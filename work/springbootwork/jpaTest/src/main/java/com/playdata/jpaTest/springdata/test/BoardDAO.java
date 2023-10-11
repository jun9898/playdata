package com.playdata.jpaTest.springdata.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	BoardRepository repository;

	@Autowired
	public BoardDAO(BoardRepository repository) {
		super();
		this.repository = repository;
	}
	
	public List<BoardEntity> findAll(int pageNo) {
		// 페이지 처리를 위해 설정 정보를 담고있는 객체
		PageRequest pageRequest = PageRequest.of(pageNo, 5, Sort.by(Sort.Direction.DESC,"boardNo"));
		Page<BoardEntity> page = repository.findAll(pageRequest);
		return page.getContent();
	}
	
	public void insert(BoardEntity entity) {
		repository.save(new BoardEntity("park", "spring data CLRUD", "자동생성"));
		repository.save(new BoardEntity("hong", "Query 메소드", "Query 사용이 가능"));
		repository.save(new BoardEntity("kang", "여기어때", "취업시켜줘"));
	}

	public void update(BoardEntity entity) {
		
	}
	


}
