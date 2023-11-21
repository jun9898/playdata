package com.example.kafkasub.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class KafkaController {

//    private final KafkaMessageListenerContainer<String, String> container;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        log.info("login==============================");
//        container.start();
        log.info("==============================");
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
//        container.stop();
        return "main";
    }

}
