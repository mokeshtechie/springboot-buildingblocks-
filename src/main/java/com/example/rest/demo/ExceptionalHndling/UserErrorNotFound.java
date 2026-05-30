package com.example.rest.demo.ExceptionalHndling;

import org.springframework.web.bind.annotation.ResponseStatus;

public class UserErrorNotFound  extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserErrorNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	

}
