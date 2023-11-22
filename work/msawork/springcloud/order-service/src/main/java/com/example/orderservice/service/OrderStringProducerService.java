package com.example.orderservice.service;

import com.example.orderservice.domain.OrderDetailDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderStringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    // 물건이 주문될 때 메시지 전송

    public void sendMessage(String topic, OrderDetailDTO orderInfo) {
        // 메시지 전송 OrderDetailDTO => String
        ObjectMapper mapper = new ObjectMapper();
        String orderString = "";
        try {
            orderString = mapper.writeValueAsString(orderInfo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // publish
        kafkaTemplate.send(topic, orderString);
        log.info("=========================================# order-service의 프로듀서가 메시지 전송 : {} #=============================================", orderString);
    }

}
