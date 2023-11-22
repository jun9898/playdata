package com.example.productservice.service;

import com.example.productservice.dao.ProductDAO;
import com.example.productservice.entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ProductStringConsumerService {

    // 브로커로부터 메시지를 받으면 db에 데이터를 수정 (재고 수정)
    private final ProductDAO dao;
    @KafkaListener(topics = "ordercreate", groupId = "updatestockgroup",
                   containerFactory = "getKafkaListenerContainer")
    public void receiveMsg(String message) {
        log.info("전달받은 메시지 =================> {}" , message);
        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(message, new TypeReference<Map<Object, Object>>() {});
            log.info("변환된 메시지 =================> {}" , map);
            dao.update(map);

            // 메시지 받은 후에 상품 재고 수정
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
