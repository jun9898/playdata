package com.example.springsecuritytest.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "스프링 시큐리티 테스트";
    }

    @RequestMapping("/showauth")
    public Authentication showauth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @GetMapping("/userpage")
    public UserInfo userpage() {
        return UserInfo.builder()
                .authentication(SecurityContextHolder.getContext().getAuthentication())
                .msg("사용자가 막 접근할 수 있는 페이지")
                .build();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/adminpage")
    public UserInfo adminpage() {
        return UserInfo.builder()
                .authentication(SecurityContextHolder.getContext().getAuthentication())
                .msg("관리자가 막 접근할 수 있는 페이지")
                .build();
    }
}
