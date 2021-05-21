package com.uj.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * CreatedBy :Upendra Joshi
 */
@SpringBootApplication
public class ConsumerApplication {

	private final Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	/**
	 * Provide your own topic and group id here
	 *
	 * @param message the message
	 */
	@KafkaListener(topics = "uj-topic", groupId = "uj-group")
	public void consume(String message) {
		logger.info("#### -> Consumed message -> {}", message);
	}

}
