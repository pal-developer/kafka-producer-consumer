package com.spring.kafka.springbootkafkaproducer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;



@Configuration
public class KafkaConfiguration {
	
	@Bean
	public ProducerFactory<String,User_model> producerFactory() {
		
		Map<String,Object> kafka_config=new HashMap<>();
		
		kafka_config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		kafka_config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		kafka_config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(kafka_config);
	}
	
	@Bean
	public KafkaTemplate<String, User_model> kafkaUserTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
	
}
