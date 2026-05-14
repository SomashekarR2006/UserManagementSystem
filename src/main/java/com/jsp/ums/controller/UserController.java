package com.jsp.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ums.entity.User;
import com.jsp.ums.service.UserService;

@RestController
public class UserController {

   
	
	@Autowired
	UserService service;

	
	@PostMapping("/users")
	public ResponseEntity<?> saveUser(@RequestBody User u) {
		return service.saveUser(u);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id){
		return service.deleteById(id);
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		return service.findById(id);
	}
}
