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
    public String tokenTest() {
        return "작업 완료에용";
    }
}
