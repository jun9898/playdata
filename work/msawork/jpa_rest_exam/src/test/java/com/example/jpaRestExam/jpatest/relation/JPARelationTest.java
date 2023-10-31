package com.example.jpaRestExam.jpatest.relation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
class JPARelationTest {

    @PersistenceContext
    EntityManager em;

    @Test
    void test() {
        DeptEntity dept1 = new DeptEntity("전산실", "장동건");
        DeptEntity dept2 = new DeptEntity("인사팀", "전콜라");
        DeptEntity dept3 = new DeptEntity("기획실", "전병준");

        em.persist(dept1);
        em.persist(dept2);
        em.persist(dept3);

        EmpEntity emp1 = new EmpEntity("하은","화곡",dept1);
        EmpEntity emp2 = new EmpEntity("병준1","화곡",dept1);
        EmpEntity emp3 = new EmpEntity("병준2","화곡",dept2);
        EmpEntity emp4 = new EmpEntity("병준3","화곡",dept2);
        EmpEntity emp5 = new EmpEntity("병준4","화곡",dept3);
        em.persist(emp1);
        em.persist(emp2);
        em.persist(emp3);
        em.persist(emp4);
        em.persist(emp5);

        // sql 실행, 캐시 초기화
        em.flush();
        em.clear();

        // 모든 사원 데이터 조회
        List<EmpEntity> empList = em.createQuery("select e from EmpEntity e", EmpEntity.class)
                .getResultList();

        for (EmpEntity empEntity : empList) {
            System.out.println("empEntity.toString() = " + empEntity.toString());
            System.out.println("==============================================");
        }
    }

    @Test
    void test2() {
        DeptEntity dept = em.find(DeptEntity.class, 1L);
        List<EmpEntity> emplist = dept.getEmplist();
        System.out.println("========================");
        for (EmpEntity empEntity : emplist) {
            System.out.println(empEntity);
        }
        System.out.println("========================");

    }
}