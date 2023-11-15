package com.example.communication.restTemplate.controller;

import com.example.communication.restTemplate.dto.UserInfoRequest;
import com.example.communication.restTemplate.dto.UserInfoResponse;
import com.example.communication.restTemplate.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ApiController {

    private final RestTemplateService service;

    @GetMapping("/first")
    public String first(){
        return service.first();
    }

    @GetMapping("/getdata")
    public UserInfoResponse getdata(){
        UserInfoResponse getdata = service.getdata();
        log.info("컨트롤러에서 받은 getdata ====> {}" , getdata.getId());
        log.info("컨트롤러에서 받은 getdata ====> {}" , getdata.getPassword());
        log.info("컨트롤러에서 받은 getdata ====> {}" , getdata.getName());
        log.info("컨트롤러에서 받은 getdata ====> {}" , getdata.getUsername());
        return getdata;
    }

    @GetMapping("/paramtest")
    public UserInfoResponse paramtest(){
        UserInfoResponse getdata = service.paramtest();
        return getdata;
    }

    @GetMapping("/pathvariabletest")
    public String pathvariabletest(){
        return service.pathvariabletest();
    }

    @GetMapping("/posttest")
    public UserInfoResponse posttest(){
        return service.posttest();
    }

    @GetMapping("/exchange")
    public UserInfoRequest exchange(){
        return service.exchange();
    }

    @GetMapping("/naver")
    public String naver(){
        return service.naver();
    }

}