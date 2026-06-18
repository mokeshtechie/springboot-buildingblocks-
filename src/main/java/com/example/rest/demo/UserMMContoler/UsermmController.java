package com.example.rest.demo.UserMMContoler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.demo.ExceptionalHndling.UserErrorNotFound;
import com.example.rest.demo.config.AppConfigure;
import com.example.rest.demo.entities.User;
import com.example.rest.demo.service.useService;
import com.example.rest.demo.usermmdto.UsermmDto;

import ExceptionHandling.ServiceException;

@RestController
@RequestMapping("/mmDto")
public class UsermmController {
	@Autowired
	public useService serv;
	@Autowired
	public AppConfigure modlarMap;
	@GetMapping("/{id}")

public UsermmDto getAllId(@PathVariable("id")Long id) throws UserErrorNotFound, ServiceException{
		Optional<User>OptionalFindId = serv.userid(id);
	
		if(!OptionalFindId.isPresent())  {
		throw	new UserErrorNotFound("the usr is not trecorde");
		}
		User user = OptionalFindId.get();
//		System.out.println(user.getOrders());
		UsermmDto mmDto = modlarMap.modelMapper().map(user, UsermmDto.class);
	return mmDto;
	
}
}
