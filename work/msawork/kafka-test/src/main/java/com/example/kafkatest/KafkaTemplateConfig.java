package com.example.kafkatest;

import org.apache.catalina.mapper.Mapper;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
public class KafkaTemplateConfig {

    // kafkaTemplate객체를 빈으로 등록
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
    // Producer 객체를 만들 수 있도록 ProducerFactory 객체 생성
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerProps());
    }
    // 카프카 Producer에 대한 설정정보
    private Map<String, Object> producerProps() {

        Map<String, Object> props = new HashMap<>();
        // 카프카가 기본으로 제공하는 설정을 적용
        // 서버
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.114:9092");
        // 키 - key를 직렬화 할 수 있는 Serializer 객체 타입으로 지정
        // 직렬화 - 문자열을 패킷단위로 쪼개서 전송할 수 있는 타입으로 만들 수 있도록 지원되는 카프카 에서 제공하는 String을 다루는 클래스
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // value 에 대한 설정
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return props;
    }
}
