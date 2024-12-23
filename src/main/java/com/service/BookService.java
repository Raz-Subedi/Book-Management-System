package com.service;

import java.util.List;

import com.model.Book;

public interface BookService {

	boolean addBook(Book book);
	
	List<Book> getAllBooks();
	
	boolean updateBook(String newName, String isbn );
	
	boolean deleteBook(String isbn);
}
