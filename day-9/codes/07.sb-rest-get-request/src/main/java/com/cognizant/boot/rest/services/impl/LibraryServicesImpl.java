package com.cognizant.boot.rest.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.boot.rest.models.Book;
import com.cognizant.boot.rest.repository.LibraryRepository;
import com.cognizant.boot.rest.services.LibraryServices;

@Service
public class LibraryServicesImpl implements LibraryServices {
	private LibraryRepository libraryRepo;
	
	//constructor injection
	public LibraryServicesImpl(LibraryRepository libraryRepo) {
		super();
		this.libraryRepo = libraryRepo;
	}

	@Override
	public Book findBookById(Integer bid) {
		List<Book> books = libraryRepo.getBooks();
		Book searchedBook = books.stream()
								 .filter(bk -> bk.getBookId().equals(bid))
								 .findFirst()
								 .orElse(null);
		
		return searchedBook;
	}

	@Override
	public List<Book> findAll() {
		List<Book> books = libraryRepo.getBooks();
		return books;
	}

}
