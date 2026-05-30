package com.example.rest.demo.controller;


import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.rest.demo.entities.User;
import com.example.rest.demo.service.useService;

import ExceptionHandling.ServiceException;
import ExceptionHandling.UserExistException;
import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	public useService UserService;
	
	@GetMapping("/View")
	 public List<User> Getalldata(){
		return UserService.GetAllData();
		
	}
	@PostMapping("/save")
	public ResponseEntity<Void> saveUser(
	        @RequestBody User user,
	        UriComponentsBuilder builder) {

	    try {
	        User savedUser = UserService.saveall(user);

	        return ResponseEntity.created(
	                builder.path("/user/{id}")
	                       .buildAndExpand(savedUser.getSno())
	                       .toUri())
	                .build();

	    } catch (UserExistException e) {
	        throw new ResponseStatusException(
	                HttpStatus.BAD_REQUEST,
	                e.getMessage());
	    }
	}

     @GetMapping("/User/{id}")
     public Optional<User> findId(@PathVariable("id") Long id){
    	 try {
			return UserService.userid(id);
		 } catch (ServiceException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		 }
		 
	
     }
     @PutMapping("/User/{id}")
     public User update(@PathVariable("id") Long id, @RequestBody User user) {
         try {
			return UserService.updateId(id, user);
		 } catch (ServiceException e) {
			 
			 throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		 }
     }
     
     @DeleteMapping("/delete/{id}")
     public void delete(@PathVariable("id") Long id) {
    	  try {
			UserService.deleteId(id);
		  } catch (ServiceException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		  }
     }
     @GetMapping("/name/{firstName}")
     public Optional<User> username(@PathVariable String firstName) {
         return UserService.findusername(firstName);
     }
}
