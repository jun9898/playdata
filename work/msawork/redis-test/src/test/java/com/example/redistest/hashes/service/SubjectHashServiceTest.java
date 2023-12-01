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
    private SubjectHashService service;

    @Test
    void save() {
        Subject subject = new Subject(
                "subject001",
                "java",
                25000,
                "info"
        );
        Subject resultSubject = service.save(subject);
        System.out.println("resultSubject.toString() = " + resultSubject.toString());
    }

    @Test
    void findById() {
        Subject subject001 = service.findById("subject001");
        System.out.println("subject001 = " + subject001.toString());

    }

}