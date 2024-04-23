package com.e2e.bc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.e2e.bc.models.ErrorModel;
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorModel> handleBookNotFoundException(BookNotFoundException ex) {
		
		
		return  new ResponseEntity<ErrorModel>(new ErrorModel(ex.getMessage(),HttpStatus.NOT_FOUND.name(),"404"), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DuplicateBookException.class)
	public ResponseEntity<ErrorModel> handleDuplicateBookException(DuplicateBookException ex) {
		
		
		return  new ResponseEntity<ErrorModel>(new ErrorModel(ex.getMessage(),HttpStatus.CONFLICT.name(),"409"), HttpStatus.CONFLICT);
	}

}
