package com.kafka.cunsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.producer.dto.Customer;

@Service
public class KafkaMessageListener {

	Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

	@KafkaListener(topics = "customTopic", groupId = "sj-consumer-group")
	public void consumeEvents(Customer message) {
		logger.info("Consumer1 consume the message {}", message);
	}

//	// READ FROM SPECIFIC PARTITION
//	@KafkaListener(topics = "customTopic", groupId = "sj-consumer-group", topicPartitions = {
//			@TopicPartition(topic = "customTopic", partitions = { "2" }) })
//	public void consume(String message) {
//		logger.info("Consumer 1 is consuming message {}", message);
//	}

//	@KafkaListener(topics = "customTopic",groupId = "sj-consumer-group")
//	public void consume2(String message) {
//		logger.info("Consumer2 consume the message {}", message);
//	}
//	
//	@KafkaListener(topics = "customTopic",groupId = "sj-consumer-group")
//	public void consume3(String message) {
//		logger.info("Consumer3 consume the message {}", message);
//	}
//	
//	@KafkaListener(topics = "customTopic",groupId = "sj-consumer-group")
//	public void consume4(String message) {
//		logger.info("Consumer4 consume the message {}", message);
//	}

}
