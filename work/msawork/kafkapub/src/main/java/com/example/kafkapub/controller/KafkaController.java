package com.example.kafkapub.controller;

import com.example.kafkapub.service.ExamProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class KafkaController {

    private final ExamProducer producer;


    @GetMapping("/pub_page")
    public String pubpage() {
        return "pub";
    }

    @GetMapping("/pub")
    public String pub() {
        // 버튼을 누를때마다 메시지를 카프카 브로커로 전송
        log.info("전송 요청");
        producer.sendMessage("ok");
        return "pub";
    }

}
