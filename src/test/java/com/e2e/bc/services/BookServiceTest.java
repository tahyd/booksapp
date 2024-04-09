package com.e2e.bc.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.e2e.bc.exceptions.BookNotFoundException;
import com.e2e.bc.exceptions.DuplicateBookException;
import com.e2e.bc.models.Book;
import com.e2e.bc.repository.BookRepository;
@ExtendWith(MockitoExtension.class)
class BookServiceTest {
	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private BookService bookService;
   
	@Test
	void testCreateNewBook() {
	
		when(bookRepository.save(any(Book.class))).thenReturn(new Book(101,"", "", 0));
		Book id=null;
		try {
			id = bookService.createNewBook(new Book(101, "", "", 0));
		} catch (DuplicateBookException e) {
			
			e.printStackTrace();
			
		}
		assertEquals(101, id.getId());
	}

	@Test
	void testGetBook() throws BookNotFoundException {
		
		Book book = new Book(101, "", "", 0);
		
		when(bookRepository.findById(101)).thenReturn(Optional.of(book));
		
		
			assertEquals(book, bookService.getBook(101));
		
			
	}

	@Test
	void testGetAllBooks() {
	
	List<Book> books = List.of(new Book(101, "", "", 0),new Book(102, "", "", 0));
		
		when(bookRepository.findAll()).thenReturn(books);
		assertEquals(2, bookService.getAllBooks().size());
		
	}
/*
	@Test
	void testDeleteBookById() {
		
		
	}

	@Test
	void testUpdateBook() {
		fail("Not yet implemented");
	}
*/
}
