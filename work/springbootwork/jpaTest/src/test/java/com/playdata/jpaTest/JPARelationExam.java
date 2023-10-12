package com.playdata.jpaTest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.playdata.jpaTest.relation.CategoryEntity;
import com.playdata.jpaTest.relation.ProductEntity;


@SpringBootTest
@Transactional
@Rollback(false)
class JPARelationExam {
	
	@PersistenceContext
	EntityManager em;

	@Test
	@Disabled
	void test() {
		
		CategoryEntity phone = new CategoryEntity("phone", "test");
		CategoryEntity cpu = new CategoryEntity("cpu", "test");
		
		em.persist(phone);
		em.persist(cpu);
		
		ProductEntity product1 = new ProductEntity("갤럭시 1","samsung", 10000, phone);
		ProductEntity product2 = new ProductEntity("갤럭시 2","samsung", 10000, phone);
		ProductEntity product3 = new ProductEntity("cpu 3","samsung", 10000, cpu);
		ProductEntity product4 = new ProductEntity("cpu 4","samsung", 10000, cpu);
		
		em.persist(product1);
		em.persist(product2);
		em.persist(product3);
		em.persist(product4);

		em.flush();
		em.clear();
		
		
		List<ProductEntity> prolist = em.createQuery("select e from ProductExamEntity e", ProductEntity.class)
										.getResultList();
		System.out.println("=============================");
		for ( ProductEntity pro : prolist) {
			System.out.println("pro.name ==> " + pro.getProductName());
			System.out.println("pro.company ==> " + pro.getCompany());
			System.out.println("pro.price ==> " + pro.getPrice());
			System.out.println("pro.categoryName ==> " + pro.getCategory().getCategoryName());
			System.out.println("=============================");
		}
		
	}

}
