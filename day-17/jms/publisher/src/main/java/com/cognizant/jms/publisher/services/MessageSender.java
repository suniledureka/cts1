package com.cognizant.jms.publisher.services;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {
	private JmsTemplate jmsTemplate;

	public MessageSender(JmsTemplate jmsTemplate) {
		super();
		this.jmsTemplate = jmsTemplate;
	}
	
    public void sendMessage(String destination, String message) {
        jmsTemplate.convertAndSend(destination, message);
        System.out.println("Sent message: " + message + " to " + destination);
    }	
}
