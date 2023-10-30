package org.example.repository;

import org.example.model.CommentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Comment;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    EntityManager em;

    @Test
    void test1() {
        List<CommentEntity> all = commentRepository.findAll();

        for (CommentEntity entity : all) {
            System.out.println(entity);
        }
    }

    @Test
    @Rollback(value = false)
    void test2() {
        System.out.println("메소드 호출 전");
        CommentEntity entity = new CommentEntity("testwriter", "testcomment", 5);
        em.persist(entity);
        em.persist(entity);
        em.persist(entity);
        CommentEntity entity2 = new CommentEntity("testwriter2", "testcomment2", 5);
        System.out.println("메소드 호출 후");
        em.flush(); // sql문을 모두 실행
        em.clear(); // 캐시를 비우라는 의미
        System.out.println("====================================");

        CommentEntity findEntity = em.find(CommentEntity.class,7L);
        System.out.println(findEntity);
    }



}