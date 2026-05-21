package com.example.rest.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.rest.demo.repository.UserRepository;

import ExceptionHandling.ServiceException;
import ExceptionHandling.UserExistException;
import jakarta.persistence.Id;

import com.example.rest.demo.entities.User;

@Service
public class useService {
	@Autowired
	public  UserRepository  rep;
	
	
	
	public List<User> GetAllData(){
		return rep.findAll();		
		
	}
	public User saveall(User user) throws UserExistException {

	    Optional<User> existName =
	            rep.findByFirstName(user.getFirstName());

	    if (existName.isPresent()) {

	        throw new UserExistException(
	                "user already is exist in repository");
	    }

	    return rep.save(user);
}
	
	
	public Optional<User> userid(Long id) throws ServiceException {
		Optional<User>user = rep.findById(id);
		if(!user.isPresent()) {
			throw new ServiceException("there is no id on it");
		}
		return user;
	}
    
	public User updateId (Long id , User user)   throws ServiceException{
		
		user.setSno(id);
		Optional<User>userUpdate = rep.findById(id);
		if(!userUpdate.isPresent()) {
			throw new ServiceException("we cant update cause there no id");
		}
		return rep.save(user);		
	}
	
	public void deleteId (Long id) throws ServiceException {
		Optional<User>userDelete = rep.findById(id);
		if(!userDelete.isPresent()) {
			throw new ServiceException("we cant delete cause there no id");
		}
		if(rep.findById(id).isPresent()) {
			rep.deleteById(id);
		}
	}
	
	public Optional<User> findusername(String firstName) {
		 return rep.findByFirstName(firstName);
		
	}
}
