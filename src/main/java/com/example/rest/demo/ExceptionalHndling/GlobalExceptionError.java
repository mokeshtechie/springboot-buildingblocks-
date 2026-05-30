package com.example.rest.demo.ExceptionalHndling;

import java.util.Date;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolationException;
@ControllerAdvice
public class GlobalExceptionError extends ResponseEntityExceptionHandler {


	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
             CustomerErrorDetial ContentOfCustomer = new CustomerErrorDetial(new Date(),"the validation which does main error",ex.getMessage());
		return new ResponseEntity<>(ContentOfCustomer,HttpStatus.BAD_REQUEST);
	}
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		 CustomerErrorDetial ContentOfCustomer = new CustomerErrorDetial(new Date(),"this method is not allow to post  ",ex.getMessage());

		return handleExceptionInternal(ex, null, headers, status, request);
	}

	@ExceptionHandler(UserErrorNotFound.class)
    public ResponseEntity<Object> UserErroeNotFound(
            UserErrorNotFound ex,
            WebRequest request) {

        CustomerErrorDetial error =
                new CustomerErrorDetial(
                        new Date(),
                        ex.getMessage(),
                        request.getDescription(false));

        return new ResponseEntity<>( error,  HttpStatus.NOT_FOUND);
    }
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object>handleConstrainVoilationException(ConstraintViolationException ex,WebRequest request){
		CustomerErrorDetial err = new CustomerErrorDetial(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}

}
