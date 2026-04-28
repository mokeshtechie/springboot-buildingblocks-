package com.example.rest.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.demo.entities.User;
import com.example.rest.demo.service.useService;

@RestController
public class UserController {
	
	@Autowired
	public useService UserService;
	
	@GetMapping("/View")
	 public List<User> Getalldata(){
		return UserService.GetAllData();
		
	}
	 @PostMapping("/save")
	 public User saveAll( @RequestBody User user){
		 return UserService.saveall(user);
	 }
     @GetMapping("/User/{id}")
     public Optional<User> findId(@PathVariable("id") Long id){
    	 return UserService.userid(id);
     }
     @PutMapping("/User/{id}")
     public User update(@PathVariable("id") Long id, @RequestBody User user) {
         return UserService.updateId(id, user);
     }
     
     @DeleteMapping("/delete/{id}")
     public void delete(@PathVariable("id") Long id) {
    	  UserService.deleteId(id);
     }
     @GetMapping("/name/{firstName}")
     public List<User> username(@PathVariable String firstName) {
         return UserService.findusername(firstName);
     }
}
