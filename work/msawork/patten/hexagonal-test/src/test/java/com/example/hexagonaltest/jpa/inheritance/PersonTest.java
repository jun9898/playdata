package com.example.hexagonaltest.jpa.inheritance;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class PersonTest {
    @Autowired
    EntityManager em;
    @Test
    void test(){
        Student student = new Student(null,"장동건","서울","1234","stu001");
        em.persist(student);
        em.flush();
        em.clear();
    }

}