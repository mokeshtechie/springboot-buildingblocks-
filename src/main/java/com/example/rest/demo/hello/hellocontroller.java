package com.example.rest.demo.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellocontroller {
	@RequestMapping(method=RequestMethod.GET,path="/helloworld")
	public String helloworld(){
		return "hello world";
	}
	@GetMapping(value = "/hellobeam", produces = "application/json")
	public UserDetails hellobeam(){
	    return new UserDetails("ramesh","rama","epstien island");
	}
	

}
