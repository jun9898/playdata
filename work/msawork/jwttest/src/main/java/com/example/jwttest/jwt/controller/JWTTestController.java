package com.example.jwttest.jwt.controller;

import com.example.jwttest.jwt.model.CustomerUserDetail;
import com.example.jwttest.jwt.model.SampleDTO2;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
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

    @GetMapping("/my/api/mypage")
    public SampleDTO2 userTest(Authentication mydata) {
        //내 정보 조회 - SecurityuContextHolder 안에 SecurityContext 에 Authentication
        //이 저장되어 있으므로 스프링이 자동으로 객체를 컨트롤러에 넘겨준다
        CustomerUserDetail userDetail = (CustomerUserDetail) mydata.getPrincipal();
        ModelMapper mapper = new ModelMapper();
        SampleDTO2 dto = mapper.map(userDetail.getEntity(), SampleDTO2.class);
        return dto;
    }

    @GetMapping("/admin/api/test")
    public String adminTest() {
        return "어드민테스트";
    }
}
