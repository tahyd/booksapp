package com.e2e.bc.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.e2e.bc.exceptions.DuplicateBookException;
import com.e2e.bc.models.Book;
import com.e2e.bc.services.IBookService;

import jakarta.websocket.server.PathParam;

@RestController
public class BooksController {
	
	
	private static final Logger logger = LogManager.getLogger(BooksController.class);

	@Autowired
	IBookService bookService;
	@GetMapping(value="/hello",produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	
	
	public String home() {
		
		logger.info("Hello World");
		return "HelloWorld";
	}
	
	
	
	
	
	@PostMapping("/book")
	public Book book(@RequestBody Book book) throws DuplicateBookException {
		return bookService.createNewBook(book);
	}
	@PostMapping("/bookInfo")
	
	public Book bookInfo(@RequestParam("author") String auther) {
		return new Book(0, auther, auther, 0);
	}

}
