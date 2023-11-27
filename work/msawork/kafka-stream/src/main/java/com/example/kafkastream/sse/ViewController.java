package com.example.kafkastream.sse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/test1")
    public String test1(){
        return "ssetest1";
    }

    @GetMapping("/prdshow")
    public String test2(){
        return "product";
    }
}
