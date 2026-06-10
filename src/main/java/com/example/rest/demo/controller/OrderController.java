package com.example.rest.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.demo.ExceptionalHndling.UserErrorNotFound;
import com.example.rest.demo.entities.Order;
import com.example.rest.demo.entities.User;
import com.example.rest.demo.repository.OrderRepository;
import com.example.rest.demo.repository.UserRepository;

@RestController
@RequestMapping("/User")
public class OrderController {
@Autowired
public UserRepository repo; 
@Autowired
public OrderRepository orderRep;

@GetMapping("/{UserId}/Order")
public List<Order> GetAllOrder(@PathVariable  Long UserId) throws UserErrorNotFound{
	Optional<User>OptinalUserId = repo.findById(UserId);
	if(!OptinalUserId.isPresent()) {
				throw new UserErrorNotFound("no user is found");
	}
	return OptinalUserId.get().getOrders();
}

@PostMapping("/{UserId}/Order")
public   Order postDetial(@PathVariable Long UserId , @RequestBody Order order) throws UserErrorNotFound{
	Optional <User> checkUser =  repo.findById(UserId);
	if(!checkUser.isPresent()) {
		throw new UserErrorNotFound("this user not exist");
	}
	User user = checkUser.get();
	order.setUser(user);
return
	orderRep.save(order);	
}
@GetMapping("/{userId}/Order/{orderId}")
public Order getOrderById(
        @PathVariable Long userId,
        @PathVariable Long orderId)
        throws UserErrorNotFound {

    User user = repo.findById(userId)
            .orElseThrow(() ->
                    new UserErrorNotFound("User not found"));

    return orderRep.findById(orderId)
            .orElseThrow(() ->
                    new RuntimeException("Order not found"));
}
}
