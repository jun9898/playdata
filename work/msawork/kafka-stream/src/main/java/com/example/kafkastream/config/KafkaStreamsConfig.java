package com.example.kafkastream.config;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafkaStreams
// 스프링이 기본으로 제공하는 스트림빌더를 사용할 수 있도록
public class KafkaStreamsConfig {

//    @Bean
    public KStream<String, String> makeStream(StreamsBuilder builder) {
        // 스트림을 구독하고 재발행을 하기 위해 생성
        KStream<String, String> stream = builder.stream("streamstest");
        // return 값 없이 출력하기 위한 용도
        stream.peek((key, value) -> {
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        })
                .map((key, value) -> KeyValue.pair(key,value+ " ==================> result"))
                .to("streams-result");
        return stream;
    }

    @Bean
    public KStream<String, String> filterStreams1(StreamsBuilder builder){
        KStream<String, String> stream = builder.stream("num-topic");
        stream.peek((key, value) -> {
                    System.out.println("key = " + key);
                    System.out.println("value = " + value);
                })
                .filter((key, value) -> Integer.parseInt(value) % 2 != 0)
                .to("sink-topic");
        return stream;
    }

    @Bean
    public KStream<String, String> filterStreams2(StreamsBuilder builder) {
        KStream<String, String> stream = builder.stream("source-topic");
        stream.peek((key, value) -> {
                    System.out.println("key = " + key);
                    System.out.println("value = " + value);
                })
                .filter((key, value) -> value.length() >= 5)
                .to("sink-topic");
        return stream;
    }

    @Bean
    public KStream<String, String> makeStreams2(StreamsBuilder builder) {
        KStream<String, String> stream = builder.stream("streamstest");
        stream.groupBy((key, value) -> value)
                .count()
                .toStream()
                .peek((key, value) -> {
                    System.out.println("key = " + key);
                    System.out.println("value = " + value);
                })
                .to("streams-result");
        return stream;
    }

    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration streamConfig() {
        Map<String, Object> config = new HashMap<>();
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.6:9092");
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "stream-test-1-4");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        // 재시작하면서 commit이 되지 않은 값이 있는 경우 재 구독을 시도하므로 - 테스트하는 동안
        // config.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, StreamsConfig.EXACTLY_ONCE);

        return new KafkaStreamsConfiguration(config);
    }
}
