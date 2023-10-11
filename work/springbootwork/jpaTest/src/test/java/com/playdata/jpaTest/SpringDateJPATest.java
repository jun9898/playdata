package com.playdata.jpaTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.DiscriminatorValue;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.playdata.jpaTest.springdata.test.BoardDAO;
import com.playdata.jpaTest.springdata.test.BoardEntity;
import com.playdata.jpaTest.springdata.test.BoardRepository;

@SpringBootTest
@Transactional
@Rollback(false)
class SpringDateJPATest {

	@Autowired
	BoardRepository repository;
	@Autowired
	BoardDAO dao;

	// DAO의 insert 메소드를 호출
	@Test
	@Disabled
	void daoInsertTest() {
		dao.insert(null);
	}
	
	@Test
	@Disabled
	void findTest() {
		System.out.println("=========================================");
//		System.out.println(repository.getClass());
		List<BoardEntity> boardlist = repository.findAll();
		print(boardlist);
		System.out.println("=========================================");
		System.out.println("=========================================");
		// 내림차순 정렬을 적용하기
		// Sort.by(정렬기준, 정렬할 컬럼명)
		print(repository.findAll(Sort.by(Direction.DESC, "boardNo")));
		// id 를 기준으로 조회
		// Lists.newArrayList(1L,2L,3L)
		/*		
			List<Long> list = new ArrayList<Long>()
			list.add(1L);
			list.add(2L);
			list.add(3L);
			와 동일
		*/		
		print(repository.findAllById(Lists.newArrayList(1L,2L,3L)));
	}

	void print(List<BoardEntity> list) {
		for (BoardEntity board : list) {
			System.out.println(board);
		}
	}
	
	@Test
	@Disabled
	public void insertall() {
		BoardEntity board1 = new BoardEntity("jeon", "커피가 너무 달아", "아아 마실걸");
		BoardEntity board2 = new BoardEntity("jeon", "오늘 로그인 구현해야지", "집가고싶다");
		BoardEntity board3 = new BoardEntity("jeon", "스프링데이터JPA", "적용시키자");
		
		// 한꺼번에 insert
		repository.saveAll(Lists.newArrayList(board1,board2,board3));
	}
	
	@Test
	@Disabled
	public void readTest() {
		// pk로 조회
		BoardEntity board1 = repository.findById(1L).get();
		Optional<BoardEntity> board2 = repository.findById(1L);
		System.out.println(board1);
		System.out.println(board2);
		// 갯수 조회
		long count = repository.count();
		System.out.println("레코드 개수 ====> "  + count);
		
		
		boolean state = repository.existsById(1L);
		boolean state2 = repository.existsById(100L);
		System.out.println("실행결과1 ===> " + state);
		System.out.println("실행결과2 ===> " + state2);
	}
	
	@Test
	@Disabled
	public void update() {
		BoardEntity board = repository.findById(1L).get();
		System.out.println(board);
		board.setTitle("안쉬는시간");
		// save 메소드는 객체를 새롭게 만들어서 작업하는 경우 insert문이 만들어지고
		// 조회한 객체의 setter메소드를 이용해서 값을 변경하는 경우 save 를 호출하면 update문이 만들어진다.
		// 내부에서 최초만들어진 객체의 스냅샷을 저장하고 있다가 변경이 감지되면 update를 호출
		repository.save(board);
		BoardEntity updateBoard = repository.findById(1L).get();
		System.out.println("수정 후 보드 ===> " + board);
	}
	
	@Test
	@Disabled
	public void pageTest() {
		// 페이지처리를 하기 위해서 PageRequest객체를 생성해서 작업
		Page<BoardEntity> list =  repository.findAll(PageRequest.of(0, 5));
		// (PageRequest.of(0, 5)) 0은 현제 페이지 번호, 5는 한 페이지에 보여줄 레코드 갯수
		System.out.println("===============================================");
		System.out.println("boardlist : " + list);
		System.out.println("total(전체 레코드수) " + list.getTotalElements());
		System.out.println("totalPage(페이지수) " + list.getTotalPages());
		System.out.println("현재 조회한 레코드수 " + list.getNumberOfElements());
		System.out.println("정렬 " + list.getSort());
		System.out.println("한페이지의 사이즈 " + list.getSize());
		// 페이징 처리 후 page 객체에 저장된 레코드를 꺼내서 ArrayList에 담에서 리턴
		print(list.getContent()); 
		System.out.println("===============================================");
	}
	
	@Test
	public void querymethodtest() throws ParseException {
		System.out.println("===============================================");
		print(repository.findByTitle("쉬는시간"));
		System.out.println("===============================================");

		System.out.println("===============================================");
		print(repository.findByTitleLike("여기어때"));
		System.out.println("===============================================");

		System.out.println("===============================================");
		print(repository.findByTitleContaining("기"));
		System.out.println("===============================================");

		System.out.println("===============================================");
		print(repository.findByTitleStartingWith("커피"));
		System.out.println("===============================================");

		System.out.println("===============================================");
		print(repository.findByTitleEndingWith("지"));
		System.out.println("===============================================");

		System.out.println("===============================================");
		print(repository.findByBoardNoGreaterThanEqual(2L));
		System.out.println("===============================================");

		System.out.println("===============================================");
		print(repository.findByCreateDateGreaterThanEqual(new SimpleDateFormat("yyyy-MM-dd").parse("2023-10-11")));
		System.out.println("===============================================");
	}
	
	
	
	
	
	
	
	
	
	

}
