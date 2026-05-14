package com.jsp.ums.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.jsp.ums.dao.UserDao;
import com.jsp.ums.entity.User;
import com.jsp.ums.responsestructure.ResponseStructure;

@Service
public class UserService {
	
	@Autowired
	UserDao dao;
	
	
	ResponseStructure rs=new ResponseStructure();

	public ResponseEntity<?> saveUser(User u) {
		User user=dao.saveUser(u);
		rs.setStatus(201);
		rs.setMessage("User saved Successfully Done!");
		rs.setBody(user);
		return ResponseEntity.status(201).body(rs);
	}

	public ResponseEntity<?> deleteById(@PathVariable int id) {
		Optional<User> optional=dao.findById(id);
		if(optional.isPresent()) {
			dao.deleteById(id);
			rs.setStatus(200);
			rs.setMessage("Deleted successfully!");
			rs.setBody("User Deleted");
			return ResponseEntity.status(200).body(rs);
	}
		else {
			rs.setStatus(400);
			rs.setMessage("Invalid id, User not found..!");
			rs.setBody("invalid id");
			return ResponseEntity.status(400).body(rs);
		}
	}

	public ResponseEntity<?> findAll() {
		List<User> users= dao.findAll();
		rs.setStatus(200);
		rs.setMessage("All Users found  Successfully!");
		rs.setBody(users);
		return ResponseEntity.status(200).body(rs);
	}
	
	public ResponseEntity<?> findById(@PathVariable int id){
		
	Optional<User> optional=dao.findById(id);
	
	if(optional.isPresent()) {
		rs.setStatus(200);
		rs.setMessage("User found  Successfully!");
		rs.setBody(optional);
		return ResponseEntity.status(200).body(rs);
	}
	else {
		rs.setStatus(404);
		rs.setMessage("User not found..!");
		rs.setBody(null);
		return ResponseEntity.status(404).body(rs);
	}
	}
	
	
	
}
