package com.uj.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * CreatedBy :Upendra Joshi
 */
@SpringBootApplication
@EnableScheduling
public class ProducerApplication {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private static final Logger logger = LoggerFactory.getLogger(ProducerApplication.class);
	private static final String TOPIC = "uj-topic";

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	/**
	 * You can change the time accordingly
	 */
	/* This Job Will Run Every 5000 millisecond (5 seconds) */
	@Scheduled(fixedRate = 5000)
	public void sendMessage() {
		String message = "Hello UJ ,I hope You Are Still Awake!!!";
		logger.info("#### -> Producing message -> {}", message);
		this.kafkaTemplate.send(TOPIC, message);
	}

}
