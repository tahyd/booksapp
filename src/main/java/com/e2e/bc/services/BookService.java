package com.e2e.bc.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2e.bc.controllers.BooksController;
import com.e2e.bc.exceptions.BookNotFoundException;
import com.e2e.bc.exceptions.DuplicateBookException;
import com.e2e.bc.models.Book;
import com.e2e.bc.repository.BookRepository;
@Service
public class BookService  implements IBookService{
	private static final Logger logger = LogManager.getLogger(BooksController.class);
	@Autowired
       private BookRepository bookRepository;
	@Override
	public Book createNewBook(Book book) throws DuplicateBookException {
		
		
		      bookRepository.findById(book.getId()).orElseThrow(()->new DuplicateBookException("Book already in database"));
		
		          
		
		return bookRepository.save(book);
	}

	@Override
	public Book getBook(int bookId) throws BookNotFoundException {
		
		
	   return bookRepository.findById(bookId).orElseThrow(()->new BookNotFoundException("No Book avaiable with id : "+bookId));
	}

	@Override
	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();
	}

	@Override
	public boolean deleteBookById(int bookId) throws BookNotFoundException {
		
		return false;
	}

	@Override
	public Book updateBook(Book book) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
