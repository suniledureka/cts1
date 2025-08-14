package com.cognizant.boot.rest.services;

import java.util.List;

import com.cognizant.boot.rest.models.Book;

public interface LibraryServices {
	public Book findBookById(Integer bid);
	public List<Book> findAll();
	
	public boolean saveBook(Book book);
	public boolean deleteBookById(Integer isbn);
}
