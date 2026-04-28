package com.example.rest.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.rest.demo.repository.UserRepository;

import jakarta.persistence.Id;

import com.example.rest.demo.entities.User;

@Service
public class useService {
	@Autowired
	public  UserRepository  rep;
	
	
	public List<User> GetAllData(){
		return rep.findAll();		
		
	}
	public User saveall(User user) {
		return rep.save(user);
		
	}
	public Optional<User> userid(Long id){
		Optional<User>user = rep.findById(id);
		return user;
	}
    
	public User updateId (Long id , User user) {
		user.setSno(id);
		return rep.save(user);		
	}
	
	public void deleteId (Long id) {
		if(rep.findById(id).isPresent()) {
			rep.deleteById(id);
		}
	}
	
	public List<User> findusername(String firstName) {
		 return rep.findByFirstName(firstName);
		
	}
}
