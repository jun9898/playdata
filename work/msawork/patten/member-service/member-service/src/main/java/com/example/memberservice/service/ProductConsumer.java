package com.example.memberservice.service;

import com.example.memberservice.dao.UserDAO;
import com.example.memberservice.dto.KafkaSendDTO;
import com.example.memberservice.dto.OrderItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
//컨슈머가 메시지를 받으면 db에 데이터를 수정(재고수정)
public class ProductConsumer {
    private final UserDAO userDAO;
    @KafkaListener(topics = "ordertopic",groupId = "updatestockgroup11",
            containerFactory = "getKafkalistenerconatainer")
    public void receiveMsg(String message){
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println(message);
        System.out.println("+++++++++++++++++++++++++++");
        ObjectMapper objectMapper = new ObjectMapper();
        KafkaSendDTO receivedata = null;
        try {
            receivedata = objectMapper.readValue(message,
                    new TypeReference<KafkaSendDTO>() {});
            System.out.println("=============전달받은 메시지의 변환==============");
            System.out.println(receivedata);
            //메시지가 전송되면 고객의 포인트가 변경되도록 수정
            // - 우선순위가 낮으므로 배송이 완료된 후에 처리해도 좋음
            //
            String userId = receivedata.getCustomerId()+"";
            int point =0;
            for(OrderItem dto : receivedata.getOrderproductlist()){
                point  = (int)(point + ( dto.getOrderPrice() * dto.getCount())*0.05);

            }
            System.out.println(point+"+++++++++++++++++++++++++++++++++++++++++++++");
            userDAO.updatePoint(userId,point);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
