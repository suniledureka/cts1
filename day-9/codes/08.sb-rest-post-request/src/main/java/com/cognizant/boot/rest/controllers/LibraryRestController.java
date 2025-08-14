package com.cognizant.boot.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
				produces = {"application/json", "application/xml"})
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
	
	@PostMapping(path = "/save",
				consumes = {"application/json", "application/xml"})
	public ResponseEntity<?> addNewBook(@RequestBody Book book){
		boolean bookAddStatus = libServices.saveBook(book);
		if(bookAddStatus)
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping(path = "/remove/{isbn}")
	public ResponseEntity<?> deleteBook(@PathVariable Integer isbn){
		boolean bookDelStatus = libServices.deleteBookById(isbn);
		if(bookDelStatus)
			return new ResponseEntity<Void>(HttpStatus.OK);
		
		return ResponseEntity.badRequest().build();
	}	
}
