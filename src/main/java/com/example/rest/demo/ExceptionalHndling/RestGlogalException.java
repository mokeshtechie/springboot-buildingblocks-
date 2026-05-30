package com.example.rest.demo.ExceptionalHndling;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestGlogalException {
	@ExceptionHandler(UserErrorNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	
	public CustomerErrorDetial UserErrorNotFound(UserErrorNotFound ex) {
		return new CustomerErrorDetial(new Date(), "as per you searching the data is exist int the repository", ex.getMessage());
		
	}

}
