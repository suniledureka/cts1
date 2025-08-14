package com.cognizant.boot.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.boot.rest.models.Book;
import com.cognizant.boot.rest.services.LibraryServices;

@RestController
@RequestMapping("/library")
public class LibraryRestController {
	@Autowired
	private LibraryServices libServices;
	
	@GetMapping(path = "/search/{isbn}",
				produces = {"application/xml", "application/json"})
	public ResponseEntity<?> searchBookById(@PathVariable Integer isbn){
		Book searchedBook = libServices.findBookById(isbn);
		if(searchedBook != null) {
			return ResponseEntity.ok().body(searchedBook);
		}
		return ResponseEntity.badRequest().body("no matching book for book id: "+isbn);
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<?> getAllBooks() {
		List<Book> books = libServices.findAll();
		return ResponseEntity.ok().body(books);		
	}
}
