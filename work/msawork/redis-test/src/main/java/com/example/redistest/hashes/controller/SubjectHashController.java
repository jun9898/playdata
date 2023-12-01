package com.example.redistest.hashes.controller;

import com.example.redistest.hashes.dto.Subject;
import com.example.redistest.hashes.service.SubjectHashService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SubjectHashController {

    // hash에 데이터 추가하기 컨트롤러 메소드
    private final SubjectHashService service;

    @PostMapping("/hashtest")
    public Subject save(@RequestBody Subject subject) {
        System.out.println("subject.toString() = " + subject.toString());
        return service.save(subject);
    }

    @GetMapping("/hashtest")
    public Subject findById(String id) {
        return service.findById(id);
    }

}
