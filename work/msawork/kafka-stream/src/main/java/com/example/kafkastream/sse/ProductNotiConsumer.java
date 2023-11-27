package com.example.kafkastream.sse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductNotiConsumer {

    private final SseProductService sseService;

    @KafkaListener(id = "pro_noti", topics = "prdcreate", containerFactory = "concurrentFactory")
    public void listen(String message) {
        log.info("=============================================");
        log.info("====================={}=====================", message);
        log.info("=============================================");
        // 메시지가 create이면 구독 신청한 클라이언트에게 메시지 전송
        if (message.equals("create")) {
            sseService.sendToClient(message);
        }
    }
}
