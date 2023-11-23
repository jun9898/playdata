package com.example.kafkastream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;

import java.util.Properties;

public class KStreamAndKTableJoinTest {
    public static void main(String[] args) {

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "jointest");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.6:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        StreamsBuilder builder = new StreamsBuilder();

        KStream<String, String> orderStream = builder.stream("order");

        KTable<String, String> customerStream = builder.table("customer");

        orderStream.join(customerStream, (orderValue, customerValue) ->
                orderValue + " : " + customerValue
        ).to("result");

        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();

    }
}
