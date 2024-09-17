package com.kafka.cunsumer;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import com.kafka.producer.dto.Customer;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Testcontainers
@Slf4j
class KafkaConsumerExampleApplicationTests {

	@Container
	static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));

	@DynamicPropertySource
	public static void initKafkaProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.kafka.consumer.bootstrap-servers", kafka::getBootstrapServers);
	}

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void testsConsumeEvents() {
		log.info("test consumeEvsnts method execution started...");
		Customer customer = new Customer(1, "smit", "test@gmail.com", "9090909090");
		kafkaTemplate.send("customTopic", customer);
		log.info("test consumeEvsnts method execution ended...");
		Awaitility.await().pollInterval(Duration.ofSeconds(3)).atMost(10, TimeUnit.SECONDS).untilAsserted(() -> {});
	}

}
