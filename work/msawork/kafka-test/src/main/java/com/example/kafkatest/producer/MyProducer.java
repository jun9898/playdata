package com.example.kafkatest.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

@Slf4j
@Component
@RequiredArgsConstructor
public class MyProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send() {
        kafkaTemplate.send("springexam", "springexam test");
    }

    // KafkaTemplate를 이용해서 비동기처리와 결과에 대한 callback 처리
    public void async(String topic, String message)  {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        future.addCallback(new KafkaSendCallback<>() {

            // 메시지 보내기가 성공하면 실행될 함수
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("========================== 메시지 전송 성공 {} ===========================", result);
            }

            // 메시지 보내기가 실패하면 실행될 함수
            @Override
            public void onFailure(KafkaProducerException ex) {
                // 실패 했을때 넘겨받는 객체를 이용해서 정보를 출력
                ProducerRecord<Object, Object> failedProducerRecord = ex.getFailedProducerRecord();
                log.info("========================== 메시지 전송 실패 {} ===========================", failedProducerRecord);
            }
        });
    }

    // kafka 동기통신
    //Kafka 동기통신
    public void sync(String topic, String message){
        ListenableFuture<SendResult<String, String>> future
                = kafkaTemplate.send(topic, message);
        try {
            future.get();   //get을 호출하면 동기통신이 된다.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }


}
