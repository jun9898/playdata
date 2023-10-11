package com.playdata.jpaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.playdata.jpaTest.entitymanager.test.PersonDAO;
import com.playdata.jpaTest.entitymanager.test.PersonEntity;

@SpringBootTest
@Transactional // 같은 트랜잭션으로 처리
@Rollback(value = false) // rollback되지 않도록 설정
class JPATest01 {
	
	@Autowired
	PersonDAO dao;

	@Test
	@Disabled
	public void test() {
		// PersonDAO의 insert메소드가 동작하는지 테스트
		System.out.println("====================================================================");
		dao.insert(new PersonEntity("test1", "전병준", 100, "기타"));
		System.out.println("====================================================================");

	}
	
	@Test
	public void readTest() {
		PersonEntity person = dao.read("5");
		System.out.println(person);
	}

}
