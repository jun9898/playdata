package com.playdata.jpaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.playdata.jpaTest.relation.DeptEntity;
import com.playdata.jpaTest.relation.EmpEntity;

@SpringBootTest
@Transactional
@Rollback(false)
class JPARelationTest {
	
	@PersistenceContext
	EntityManager em;

	@Test
	@Disabled
	void test() {
		DeptEntity dept1 = new DeptEntity("전산실", "장동건");
		DeptEntity dept2 = new DeptEntity("인사팀", "전병준");
		DeptEntity dept3 = new DeptEntity("기획실", "정하은");
		
		em.persist(dept1);
		em.persist(dept2);
		em.persist(dept3);
		
		EmpEntity emp1 = new EmpEntity("윤정숙","경기광주",dept1);
		EmpEntity emp2 = new EmpEntity("전윤근","성남",dept1);
		EmpEntity emp3 = new EmpEntity("전채원","대전",dept2);
		EmpEntity emp4 = new EmpEntity("이민호","대구",dept2);
		EmpEntity emp5 = new EmpEntity("전콜라","독산",dept3);

		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		em.persist(emp4);
		em.persist(emp5);
		
		// 초기화
		em.flush();
		em.clear();
		
		// 모든 사원데이터를 조회하기
		List<EmpEntity> emplist = em.createQuery("select e from EmpEntity e", EmpEntity.class)
										.getResultList();
		System.out.println("=============================");
		for ( EmpEntity emp : emplist) {
			System.out.println("emp.name ==> " + emp.getName());
			System.out.println("emp.addr ==> " + emp.getAddr());
			System.out.println("emp.dept_no ==> " + emp.getDept().getName());
			System.out.println("=============================");
		}
	}
		
	@Test
	void test2() {
		DeptEntity dept1 = new DeptEntity("전산실", "장동건");
		DeptEntity dept2 = new DeptEntity("인사팀", "전병준");
		DeptEntity dept3 = new DeptEntity("기획실", "정하은");
		
		em.persist(dept1);
		em.persist(dept2);
		em.persist(dept3);
		
		EmpEntity emp1 = new EmpEntity("윤정숙","경기광주",dept1);
		EmpEntity emp2 = new EmpEntity("전윤근","성남",dept1);
		EmpEntity emp3 = new EmpEntity("전채원","대전",dept2);
		EmpEntity emp4 = new EmpEntity("이민호","대구",dept2);
		EmpEntity emp5 = new EmpEntity("전콜라","독산",dept3);

		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		em.persist(emp4);
		em.persist(emp5);
		
		// 초기화
		em.flush();
		em.clear();
		
		// 모든 사원데이터를 조회하기
		List<EmpEntity> emplist = em.createQuery("select e from EmpEntity e", EmpEntity.class)
										.getResultList();
		System.out.println("=============================");
		for ( EmpEntity emp : emplist) {
			System.out.println("emp.name ==> " + emp.getName());
			System.out.println("emp.addr ==> " + emp.getAddr());
			System.out.println("emp.dept_no ==> " + emp.getDept().getName());
			System.out.println("=============================");
		}
		//dept1에 속한 데이터 조회하기 
		DeptEntity dept = em.find(DeptEntity.class, dept1.getId());
		List<EmpEntity> emplist2 = dept.getEmplist();
		System.out.println("=============================");
		
		for ( EmpEntity emp : emplist2) {
			System.out.println(emp);
			System.out.println("=============================");
		}
		
		
		
		
	}

}
