package com.example.streamsorce.controller;

import com.example.streamsorce.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class KafkaProducerController {

    private final KafkaProducerService service;

    @PostMapping("/send")
    public String test(@RequestParam("message") String message) {
        log.info(message);
        service.send(message);
        return "/index";
    }

}
