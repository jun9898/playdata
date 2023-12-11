package com.example.hexagonaltest.board.adapter.out.kafka;

import com.example.hexagonaltest.board.application.port.out.KafkaEventOutputPort;
import com.example.hexagonaltest.board.domain.MyNotiData;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerOutputAdapter implements KafkaEventOutputPort {
    @Value("${producers.topic1.name}")
    private String BASIC_TOPIC;
    @Value("${producers.topic2.name}")
    private String NOTI_TOPIC;
    private final KafkaTemplate<String, String> basicKafkaTemplate;
    private final KafkaTemplate<String, MyNotiData> notiKafkaTemplate;
    @Override
    public void boardWriteEvent(String msg) throws JsonProcessingException {
        basicKafkaTemplate.send(BASIC_TOPIC,msg);
    }

    @Override
    public void notieWriteEvent(MyNotiData data) throws JsonProcessingException {

    }
}
