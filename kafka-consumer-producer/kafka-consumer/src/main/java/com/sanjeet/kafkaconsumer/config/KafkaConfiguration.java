package com.sanjeet.kafkaconsumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
@EnableKafka //check for all the listeners
@Configuration
public class KafkaConfiguration {
		
	@Bean
	public ConsumerFactory<String,String> consumerFactory(){
		
		Map<String,Object> consumer_config=new  HashMap<>();
		consumer_config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		consumer_config.put(ConsumerConfig.GROUP_ID_CONFIG,"group_id");
		consumer_config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumer_config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		
		
		return new DefaultKafkaConsumerFactory<>(consumer_config);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String,String> factory =new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
	@Bean
	public ConsumerFactory<String,User_model> userConsumerFactory(){
		Map<String,Object> consumer_config=new  HashMap<>();
		consumer_config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		consumer_config.put(ConsumerConfig.GROUP_ID_CONFIG,"group_json");
		consumer_config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumer_config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<String,User_model>(consumer_config,new StringDeserializer(),new JsonDeserializer<>(User_model.class));
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,User_model> usermodelKafkaListenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, User_model> factory=new ConcurrentKafkaListenerContainerFactory<String, User_model>();
		
		factory.setConsumerFactory(userConsumerFactory());
		return factory;
		
	}
	
	
}
