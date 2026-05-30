package com.example.rest.demo.ExceptionalHndling;

import java.util.Date;

public class CustomerErrorDetial {
	public String ErrorDetial;
	public CustomerErrorDetial(Date cutenttime, String errorDetial, String errorMsg) {
		super();
		ErrorDetial = errorDetial;
		this.cutenttime = cutenttime;
		ErrorMsg = errorMsg;
	}
	public Date cutenttime;
    public String ErrorMsg;
}
