package com.spring.kafka.springbootkafkaproducer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {
	/*@Autowired
	KafkaTemplate< String, String> kafkaTemplate;
	private static final String topic="kafka_topic";
	
	@GetMapping("/publish/{message}")
	public String post(@PathVariable("message")final String message) {
		
		kafkaTemplate.send(topic,message);
		//run using $ bin/zookeper-server-start.sh config/zookerper.properties
		return "Published successfully";
	}
	*/
	
	//publishing json message with user_model
	
	@Autowired
	KafkaTemplate<String,User_model> kafkaUserkatemplate;
	
	private static final String  user_topic="kafka_user_topic";
	
	@GetMapping("/user/{name}")
	public String user_post(@PathVariable("name")final String name) {
	
		
		kafkaUserkatemplate.send(user_topic,new User_model(name,"uic","BCA"));
		
		return "public on port 8080";
	}
	
}
