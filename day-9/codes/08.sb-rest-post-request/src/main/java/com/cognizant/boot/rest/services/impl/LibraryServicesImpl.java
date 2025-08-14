package com.cognizant.boot.rest.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.boot.rest.models.Book;
import com.cognizant.boot.rest.repository.LibraryRepository;
import com.cognizant.boot.rest.services.LibraryServices;

@Service
public class LibraryServicesImpl implements LibraryServices {
	private LibraryRepository libraryRepo;
	private List<Book> books;
	
	//constructor injection
	public LibraryServicesImpl(LibraryRepository libraryRepo) {
		super();
		this.libraryRepo = libraryRepo;
		books = libraryRepo.getBooks();
	}

	@Override
	public Book findBookById(Integer bid) {
		Book searchedBook = books.stream()
								 .filter(bk -> bk.getBookId().equals(bid))
								 .findFirst()
								 .orElse(null);
		
		return searchedBook;
	}

	@Override
	public List<Book> findAll() {
		return books;
	}

	@Override
	public boolean saveBook(Book newBook) {
		Book book = books.stream()
					     .filter(bk -> bk.getBookId().equals(newBook.getBookId()))
					     .findAny()
					     .orElse(null);
		
		if(book == null) {
			books.add(newBook);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBookById(Integer isbn) {
		Book book = books.stream()
			     .filter(bk -> bk.getBookId().equals(isbn))
			     .findAny()
			     .orElse(null);

		if(book != null) {
			books.remove(book);
			return true;
		}
		return false;
	}

}
