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
public class ManyToManyTest {

    @PersistenceContext
    EntityManager em;

    @Test
    @Rollback(value = true)
    void test() {
        // 과목 등록
        SubjectEntity subject1 = new SubjectEntity("자바프로그래밍","이민호");
        SubjectEntity subject2 = new SubjectEntity("스프링","장동건");
        SubjectEntity subject3 = new SubjectEntity("화성학","전병준");
        em.persist(subject1);
        em.persist(subject2);
        em.persist(subject3);
        // 학생 등록
        StudentEntity student1 = new StudentEntity("전병준", "독산");
        StudentEntity student2 = new StudentEntity("전콜라", "경기광주");
        StudentEntity student3 = new StudentEntity("정하은", "화곡");
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        // 수강 신청
        StudentSubject ex1 = new StudentSubject(student1, subject1, 100);
        StudentSubject ex2 = new StudentSubject(student1, subject3, 100);
        StudentSubject ex3 = new StudentSubject(student2, subject1, 200);
        StudentSubject ex4 = new StudentSubject(student3, subject1, 300);
        StudentSubject ex5 = new StudentSubject(student3, subject2, 300);
        StudentSubject ex6 = new StudentSubject(student3, subject3, 300);
        em.persist(ex1);
        em.persist(ex2);
        em.persist(ex3);
        em.persist(ex4);
        em.persist(ex5);
        em.persist(ex6);

        em.flush();
        em.clear();

        // 학생 기준으로 수강 신청한 과목의 리스트를 조회
        StudentEntity student = em.find(StudentEntity.class, student1.getStudentId());  //세션에 있는 아이디기준으로 조회
        List<StudentSubject> studentSubjectList = student.getStudentSubjectList();
        for(StudentSubject item:studentSubjectList){
            System.out.println("조회된 1번 학생이 신청한 과목내역 : " + item);
            System.out.println(item.getSubject().getSubject());
        }

        // 과목 기준으로 신청한 학생의 리스트
        SubjectEntity subject = em.find(SubjectEntity.class, subject1.getSubId());  //세션에 있는 아이디기준으로 조회
        List<StudentSubject> studentSubjectList2 = subject.getStudentSubjectList();
        for(StudentSubject item:studentSubjectList2){
            System.out.println("조회된 1번 과목을 신청한 학생내역 : " + item.getSubject().getSubject());
            System.out.println(item.getStudent().getName());
        }
    }
}
