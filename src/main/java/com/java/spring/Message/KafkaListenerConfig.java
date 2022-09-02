package com.java.spring.Message;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaListenerConfig {



    @Bean
    public ConsumerFactory<String,Object> consumerFactory(){
        Map<String,Object> objectMap=new HashMap<>();
        objectMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        objectMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        objectMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        objectMap.put(ConsumerConfig.GROUP_ID_CONFIG,"grup1");

        return new DefaultKafkaConsumerFactory<>(objectMap);
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,Object> factory(){
        ConcurrentKafkaListenerContainerFactory<String,Object> factory=new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }



}
