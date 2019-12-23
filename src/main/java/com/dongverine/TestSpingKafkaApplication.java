package com.dongverine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication
public class TestSpingKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpingKafkaApplication.class, args);
	}

}
