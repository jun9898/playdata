package com.example.redistest.hashes.service;

import com.example.redistest.hashes.dto.Subject;
import com.example.redistest.hashes.repository.SubjectRedisRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SubjectHashServiceTest {
    @Autowired
    private SubjectRedisRepository repository;
    @Test
    void save(){
        Subject subject =
                new Subject("subject001","java","25000","info");
            Subject resultsubject =  repository.save(subject);

        System.out.println(subject);
        System.out.println(resultsubject);
        System.out.println(resultsubject.getId().equals(subject.getId()));
    }
}










