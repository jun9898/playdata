package com.example.jwttest.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTTestController {

    @GetMapping("/test")
    public String test() {
        return "간단테스트";
    }

    @PostMapping("/test")
    public String filterTest() {
        return "작업 완료에용";
    }

    @GetMapping("/my/api/test")
    public String userTest() {
        return "유저테스트";
    }

    @GetMapping("/admin/api/test")
    public String adminTest() {
        return "어드민테스트";
    }
}
