package com.example.mythirdservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/third")
@Slf4j
public class ThirdController {

    @GetMapping("/test")
    public String testMethod() {
        log.info("third service 컨트롤러 요청");
        return "세 번째 서비스 입니다";
    }
}
