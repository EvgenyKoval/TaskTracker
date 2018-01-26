package com.example.tasktracker.service;

import com.example.tasktracker.entities.User;
import com.example.tasktracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserService {
	@Autowired
	private UserRepository repo;

	public User findOne(Long id) {
		User user = repo.findOne(id);
//		user.getCreatedprojects().iterator();
		return user;
	}

	public User save(User user) {
		return repo.save(user);
	}
}
