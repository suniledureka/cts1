package com.cognizant.cms;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.cms.entities.Contact;
import com.cognizant.cms.repositories.ContactRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	static String projectName = "online bookstore";
	static int version = 12;
	
	private ContactRepository contactRepo;
	private Contact contact;
	
	// constructor injection
	@Autowired
	public Application(ContactRepository contactRepo) {
		super();
		this.contactRepo = contactRepo;
	}

	public static void main(String[] args) {
		LOGGER.info("initializing spring container");
		SpringApplication.run(Application.class, args);
		LOGGER.error("spring container initialized - {}, {}", projectName, version);
	}

	@Override
	public void run(String... args) throws Exception {
		String cname = "Ajay";
		Optional<Contact> optContact = contactRepo.findByContactName(cname);
		if(optContact.isPresent()) {
			contact = optContact.get();
			LOGGER.info(contact.toString());
		}else {
			LOGGER.error("no matching contact for contact Name: {}", cname);
		}
		System.out.println();
		
		
		String cno = "6574968597";
		contact = contactRepo.findByContactNumber(cno);
		if(contact != null)
			System.out.println(contact);
		else
			LOGGER.warn("no matching contact for contact Number: {}", cno);
		System.out.println();
		
		
		optContact = contactRepo.findByContactNameAndContactNumber("Bharath", "9574968596");
		if(optContact.isPresent()) {
			contact = optContact.get();
			LOGGER.info(contact.toString());
		}else {
			LOGGER.error("no matching contact for contact Name: {}", cname);
		}
		System.out.println();
		
		List<Contact> contacts = contactRepo.findByContactNameOrContactNumber("Sanjay Patil", "9574968596");
		contacts.forEach(System.out::println);
		System.out.println();
		
		List<String> contactNames = contactRepo.findAllContactName();
		contactNames.forEach(ctname -> System.out.println(ctname));
		System.out.println();
		
		cname = "Ajay";
		optContact = contactRepo.findByCntName(cname);
		if(optContact.isPresent()) {
			contact = optContact.get();
			System.out.println(contact);
		}else {
			LOGGER.error("no matching contact for contact Name: {}", cname);
		}
		System.out.println();
		
		contacts = contactRepo.findContactsWhereNamesWith("S");
		contacts.forEach(System.out::println);
		System.out.println();
	}

}
