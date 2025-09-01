package com.cognizant.jms.publisher;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import com.cognizant.jms.publisher.services.MessageSender;

@SpringBootApplication
@EnableJms
public class PublisherApplication implements CommandLineRunner {
	@Autowired
	private MessageSender msgSender;
	
	public static void main(String[] args) {
		SpringApplication.run(PublisherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//msgSender.sendMessage("cts-queue", "Message from JMS Producer");
		Scanner sc = new Scanner(System.in);
		String msg = "";
		while(!msg.equalsIgnoreCase("end")){
			System.out.print("enter message to send: ");
			msg = sc.nextLine();
			msgSender.sendMessage("cts-queue", msg);
		}
	}

	
}
