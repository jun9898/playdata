package com.example.communicationserver.restTemplate.controller;

import com.example.communicationserver.restTemplate.model.SampleRequest;
import com.example.communicationserver.restTemplate.model.SampleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class RestServerController {
    @GetMapping("/first")
    public String firstRequest(){
        return "first communication";
    }

    @GetMapping("/getdata")
    public SampleResponse getData(){
        // DBMS에서 조회한 데이터를 응답
        SampleResponse responseDTO = new SampleResponse(1L,"jun","jun","전병준");
        return responseDTO;
    }

    @GetMapping("/paramtest")
    public SampleResponse paramtest(String username, String password, String name){
        // DBMS에서 조회한 데이터를 응답
        SampleResponse responseDTO = new SampleResponse(1L,username,password,name);
        return responseDTO;
    }

    @GetMapping("/board/{username}/{id}")
    public String pathvariable(@PathVariable String username, @PathVariable String id){
        log.info("username = {} ", username);
        log.info("id = {} ", id);
        return "pathvariable 확인 완료";
    }

    @PostMapping("/create")
    public SampleRequest create(@RequestBody SampleRequest dto) {
        log.info("post로 전송받은 dto => {}", dto);
        return dto;
    }

    @PostMapping("/exchange/test")
    public SampleRequest exchangeTest(@RequestBody SampleRequest dto,
                                      @RequestHeader("authorization") String authorization,
                                      @RequestHeader("mytoken") String token) {
        log.info("post로 전송받은 헤더 1 => {}", authorization);
        log.info("post로 전송받은 헤더 2 => {}", token);

        return dto;
    }
}
