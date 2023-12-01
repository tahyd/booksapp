package com.e2e.bc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2e.bc.exceptions.BookNotFoundException;
import com.e2e.bc.exceptions.DuplicateBookException;
import com.e2e.bc.models.Book;
import com.e2e.bc.repository.BookRepository;
@Service
public class BookService  implements IBookService{
	@Autowired
       private BookRepository bookRepository;
	@Override
	public Book createNewBook(Book book) throws DuplicateBookException {
		
		
		      // bookRepository.findById(book.getId()).orElseThrow(()->new DuplicateBookException("Book already in database"));
		
		          
		//bookRepository.findById(book.getId()).
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
