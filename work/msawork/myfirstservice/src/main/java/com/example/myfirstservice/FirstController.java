package com.example.myfirstservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
@Slf4j
public class FirstController {

    @GetMapping("/test")
//    public String testMethod(@RequestHeader("firstreq") String header) {
    public String testMethod() {
        log.info("testMethod1");
        return "첫 번째 서비스 입니다";
    }

    @GetMapping("/test2")
    public String testMethod2(@RequestHeader("firstreq") String header) {
        log.info("testMethod2");
        log.info(header);
        return "FirstController의 두번째 작업";
    }
}
