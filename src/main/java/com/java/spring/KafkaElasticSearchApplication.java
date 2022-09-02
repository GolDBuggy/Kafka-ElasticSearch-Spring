package com.java.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class KafkaElasticSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaElasticSearchApplication.class, args);
    }

}
