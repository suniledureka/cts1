package com.cognizant.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.boot.beans.DBConnection;
import com.cognizant.boot.beans.Ticket;

@SpringBootApplication
public class Application {

    private final DBConnection DBConnection;

    Application(DBConnection DBConnection) {
        this.DBConnection = DBConnection;
    }

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		Ticket ticket = context.getBean(Ticket.class);
		System.out.println(ticket);
		
		DBConnection dbcon = context.getBean(DBConnection.class);
		System.out.println(dbcon);
	}
}