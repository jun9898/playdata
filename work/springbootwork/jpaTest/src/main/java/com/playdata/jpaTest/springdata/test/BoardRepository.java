package com.playdata.jpaTest.springdata.test;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import com.playdata.jpaTest.entitymanager.test.PersonEntity;

// 1 - Entity 의 타입
// 2 - Entity의 기본키 타입
// spring jpa 내부에서 BoardRepository 객체의 구현객체를 만들어서 작업
// 내부에서 만들어서 injection하고 스캐닝
// Spring data jpa 내부에서 지원되는 기능은 대부분 구현(테이블에 종속적인 기능은 X)
// Query메소드
// Spring data jpa 에서 제공하는 기능은 모든 개발자들이 모든 테이블에 대해서 쓸 수 있는 기능들을 제공
// 이런 공통의 기능으로 작업할 수 없는 것들은 쿼리 메소드라는 기능을 이용해서 작업할 수 있도록 제공
// 1. 메소드 이름으로 쿼리를 생성
// 2. @Query 어노테이션을 이용해서 JPQL을 정의
// 3. native query -> SQL문
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

	List<BoardEntity> findByTitle(String title);
	
	// 로그인
	// PersonEntity findByIdAndPass(String id, String pass);
	List<BoardEntity> findByTitleLike(String title);
	List<BoardEntity> findByTitleStartingWith(String title);
	List<BoardEntity> findByTitleEndingWith(String title);
	List<BoardEntity> findByTitleContaining(String title);
	List<BoardEntity> findByBoardNoGreaterThanEqual(Long boardNo);
	List<BoardEntity> findByCreateDateGreaterThanEqual(Date createDate);
	Page<BoardEntity> findByContentContaining(String title,Pageable pageRequest);
	Slice<BoardEntity> findByContentStartingWith(String title,Pageable pageRequest);

}
