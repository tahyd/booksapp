package com.e2e.bc.services;

import java.util.List;

import com.e2e.bc.exceptions.BookNotFoundException;
import com.e2e.bc.exceptions.DuplicateBookException;
import com.e2e.bc.models.Book;

public interface IBookService {
	
	public Book createNewBook(Book book) throws DuplicateBookException;
	public Book getBook(int bookId) throws BookNotFoundException;
	public List<Book> getAllBooks();
	public boolean deleteBookById(int bookId) throws BookNotFoundException;
	public Book updateBook(Book book) throws BookNotFoundException;
	
}
