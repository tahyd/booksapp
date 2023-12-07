package com.e2e.bc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.e2e.bc.exceptions.DuplicateBookException;
import com.e2e.bc.models.Book;
import com.e2e.bc.services.IBookService;

@RestController
public class BooksController {
	@Autowired
	IBookService bookService;
	@GetMapping("/hello")
	public String home() {
		return "HelloWorld";
	}
	
	
	
	@PostMapping("/book")
	public Book book(@RequestBody Book book) throws DuplicateBookException {
		return bookService.createNewBook(book);
	}

}
