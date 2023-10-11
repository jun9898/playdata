package com.playdata.jpaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.playdata.jpaTest.entitymanager.exam.ProductDAO;
import com.playdata.jpaTest.entitymanager.exam.ProductEntity;

@SpringBootTest
@Transactional
@Rollback(false)
class JPAExam01 {
	
	@Autowired
	ProductDAO dao;
	
	@Test
	@Disabled
	public void test() {
		
		System.out.println("==================== insert 테스트 =================");
		dao.insert(new ProductEntity("갤럭시 2","samsung", 10000));
		dao.insert(new ProductEntity("갤럭시 3","samsung", 20000));
		dao.insert(new ProductEntity("갤럭시 4","samsung", 30000));
		

	}

	@Test
	@Disabled
	public void read() {
		
		ProductEntity readtest = dao.read(3L);
		System.out.println(readtest.getCompany());
		System.out.println(readtest.getPrice());
		System.out.println(readtest.getProductName());

	}

	@Test
	@Disabled
	public void update() {
		ProductEntity updatetest = new ProductEntity("갤럭시 12", "LG", 25000);
		updatetest.setProductNo(3L);
		dao.update(updatetest);
	}
	
	@Test
	@Disabled
	public void delete() {
		dao.delete(3L);
	}
	
	@Test
	public void list() {
		System.out.println(dao.list());
	}

	

}
