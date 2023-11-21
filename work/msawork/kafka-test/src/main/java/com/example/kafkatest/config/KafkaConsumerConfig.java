package com.example.kafkatest.config;

import com.example.kafkatest.consumer.listener.ConsumerDeaultMessageListener;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    // 어노테이션을 이용하기 위한 컨테이너
    // ConcurrentKafkaListenerContainerFactory 는 어노테이션으로 활용할 수 있고 리스너를 직접 활용 가능
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> concurrentFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
    @Bean
    public KafkaMessageListenerContainer<String, String> makeListenerContaioner() {
        ContainerProperties props = new ContainerProperties("springexam");
        // 설정정보 세팅 후
        // kafkaMessageListenerContainer를 이용해서 작업하는 경우 그룹아이디는 반드시 정의해야 한다.
        // Costomer를 만들때 기본으로 그룹아이디를 설정
        // 그룹아이디가 있어야 클라이언트 아이디가 생성되고 서버에서 인지할 수 있다.
        props.setGroupId("springexamgroup");
        props.setAckMode(ContainerProperties.AckMode.BATCH);
        props.setMessageListener(new ConsumerDeaultMessageListener());
        // 컨테이너 객체를 생성
        KafkaMessageListenerContainer container = new KafkaMessageListenerContainer(consumerFactory(), props);
        // 원하는 시점에 start 하기 위해서 자동으로 start되지 않도록 설정
        container.setAutoStartup(false);
        return container;
    }
    // Consumer를 만들수 있는 ConsumerFactory 생성
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerProps());
    }

    private Map<String, Object> consumerProps() {
        Map<String, Object> props = new HashMap<>();
        // 토픽에 저장된 데이터를 가져올때 필요한 설정 (네트워크로 전송되어 들어오는 데이터를 역직렬화)
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.6:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return props;
    }
}
