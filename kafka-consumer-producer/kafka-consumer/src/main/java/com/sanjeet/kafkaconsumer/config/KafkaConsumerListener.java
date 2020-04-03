package com.sanjeet.kafkaconsumer.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {
	
	
	@KafkaListener(topics="kafka_topic",groupId="group_id")
	public void consume(String message) {
	System.out.println("message:"+message);
	
	}
	
	@KafkaListener(topics="Kafka_user_producer_topic",groupId = "group_json",containerFactory ="usermodelKafkaListenerFactory")
	public void consumeJson(User_model user) {
		System.out.println("user json message:"+user);
		
		
	}
}
