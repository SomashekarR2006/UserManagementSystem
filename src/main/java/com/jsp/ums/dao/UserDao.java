package com.jsp.ums.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ums.entity.User;
import com.jsp.ums.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository ur;
	
	public User saveUser(User  u) {
		return ur.save(u);
	}

	public void deleteById(int id) {
		ur.deleteById(id);
	}

	public List<User> findAll() {
		return ur.findAll();
	}

	public Optional<User> findById(int id) {
		return ur.findById(id);
	}

	

}
