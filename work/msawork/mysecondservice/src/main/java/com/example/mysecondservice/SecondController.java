package com.example.mysecondservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
@Slf4j
public class SecondController {

    @GetMapping("/test")
    public String testMethod() {
        log.info("second service 컨트롤러 요청");
        return "두 번째 서비스 입니다";
    }
}
