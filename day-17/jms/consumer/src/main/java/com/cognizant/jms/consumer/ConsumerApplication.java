package com.cognizant.jms.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;

@SpringBootApplication
@EnableJms
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@JmsListener(destination = "cts-queue")
	public void receiveMessage(String msg) {
		System.out.println("Received <" + msg + ">");
	}	
}
