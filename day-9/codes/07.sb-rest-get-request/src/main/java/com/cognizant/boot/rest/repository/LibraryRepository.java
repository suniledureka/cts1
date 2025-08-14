package com.cognizant.boot.rest.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.boot.rest.models.Book;

@Repository
public class LibraryRepository {

	public List<Book> getBooks(){
		List<Book> books = new ArrayList<Book>();
		
		Book book1 = new Book(1001, "Java Reference", 575.50f);
		Book book2 = new Book(1002, "Python Reference", 750f);
		Book book3 = new Book(1003, "Microservices Reference", 875.50f);
		Book book4 = new Book(1004, "Spring with Spring Boot Reference", 1275.50f);
		
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);	
		
		return books;
	}
	
}
