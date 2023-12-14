package com.example.productservice.adapter.in.kafka;

import com.example.productservice.application.port.out.ProductDAOOutputPort;
import com.example.productservice.domain.kafka.KafkaSendDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
//컨슈머가 메시지를 받으면 db에 데이터를 수정(재고수정)
public class ProductConsumer_InputAdapter {
    private final ProductDAOOutputPort outputPort;
    private final ObjectMapper objectMapper;
    @KafkaListener(topics = "ordertopic",groupId = "updatestockgroup",
            containerFactory = "getKafkalistenerconatainer")
    public void receiveMsg(String message){
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println(message);
        System.out.println("+++++++++++++++++++++++++++");
        try {
            KafkaSendDTO datalist = objectMapper.readValue(message,
                    new TypeReference<KafkaSendDTO>() {});
            System.out.println("=============전달받은 메시지의 변환==============");
            System.out.println(datalist);
            //메시지가 전송되면 상품재고를 수정
            outputPort.update(datalist);
            //성공처리완료!!!!! - 성공메시지전송
        } catch (JsonProcessingException e) {
            //실패처리 - 실패메시지전송
           e.printStackTrace();
        }

    }
}
