package com.example.orderservice.adapter.out.kafka;

import com.example.orderservice.adapter.in.web.dto.OrderDetailDTO;
import com.example.orderservice.application.port.out.KafkaEventOutputPort;
import com.example.orderservice.domain.kafka.KafkaSendDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer_outputAdapter implements KafkaEventOutputPort {
    private final KafkaTemplate<String,String> kafkaTemplate;
    @Override
    public void orderEvent(KafkaSendDTO detailDTOS) throws JsonProcessingException {
        //메시지전송 detailDTOS => String
        ObjectMapper mapper = new ObjectMapper();
        String orderStr="";
        orderStr = mapper.writeValueAsString(detailDTOS);
        kafkaTemplate.send("ordertopic",orderStr);
        System.out.println("##################################################");
        System.out.println(orderStr);
        System.out.println("##################################################");
    }
}
