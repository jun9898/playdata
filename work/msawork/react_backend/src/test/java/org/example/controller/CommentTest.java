package org.example.controller;

import org.example.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
class CommentTest {

    @Autowired
    CommentService service;

    @Test
    void delete() {
        String delete = service.delete(2L);
        System.out.println(delete);
    }
}