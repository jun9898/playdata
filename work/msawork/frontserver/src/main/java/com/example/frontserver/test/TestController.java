package com.example.frontserver.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TestController {

    @GetMapping("/show")
    public String show() {
        return "test/test";
    }

    @PostMapping("/test")
    public String show(@RequestBody Order order) {
        System.out.println(order);
        return "test/test";
    }
}
