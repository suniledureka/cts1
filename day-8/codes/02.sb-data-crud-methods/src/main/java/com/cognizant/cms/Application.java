package com.cognizant.cms;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.cms.entities.Contact;
import com.cognizant.cms.repositories.ContactRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
	@Autowired
	private ContactRepository contactRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		//-- get the number of contacts --
		long noOfContacts = contactRepo.count();
		System.out.println("no of contacts = " + noOfContacts);
		System.out.println();
		
		//-- check whether a contact is existing with a specific id
		int cid = 101;
		boolean isExists = contactRepo.existsById(cid);
		System.out.println("is a contact with ID:" + cid + " exists = " + isExists);
		System.out.println();
		
		//-- get a Contact based on contactId( ID property value)
		Optional<Contact> optContact = contactRepo.findById(cid);
		if(optContact.isPresent()) {
			Contact ct = optContact.get();
			System.out.println(ct);
		}else {
			System.err.println("no matching contact found for CID: "+ cid);
		}
		System.out.println();
		
		//--- get Contacts based on multiple contactIds
		List<Integer> contactIds = Arrays.asList(101, 202, 605, 103, 105, 107);		
		Iterable<Contact> contacts = contactRepo.findAllById(contactIds);
		printContacts(contacts);
		System.out.println();
		
		//--- get all contacts
		Iterable<Contact> listContacts = contactRepo.findAll();
		printContacts(listContacts);
		System.out.println();
		
		//--delete a contact by id
		contactRepo.deleteById(106);
		System.out.println();
	}

	private void printContacts(Iterable<Contact> contacts) {
		contacts.forEach(ct -> {
			System.out.println(ct);
			try {
				Thread.sleep(1000);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
