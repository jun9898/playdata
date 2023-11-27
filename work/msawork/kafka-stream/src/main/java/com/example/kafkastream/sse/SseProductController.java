package com.example.kafkastream.sse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
@RequestMapping("/sse")
@RequiredArgsConstructor
@CrossOrigin
public class SseProductController {

    // 서비스 객체가 서버에 SseEmitter객체를 저장할 수 있는 메소드를 제공
    private final SseProductService service;
    private static final  Long DEFAULT_TIMEOUT = 60L * 1000 * 3;

    // 클라이언트가 구독 신청을 하는 경우 호출되는 메소드

    @GetMapping(value = "/connect/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<SseEmitter> connect(@PathVariable Long id) {
        SseEmitter emitter = new SseEmitter(DEFAULT_TIMEOUT);
        service.add(emitter, id);
        try {
            emitter.send(SseEmitter.event()
                    .name("prd") // 이벤트 이름을 connect라는 이름으로 정의
                    .data("prd test") // 503번 에러를 방지하기 위해 더미데이터
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(emitter);
    }

    // 설정을 변경하면 연결되어 있는 모든 클라이언트에 변경된 값을 전송
}
