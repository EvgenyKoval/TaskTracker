package com.example.tasktracker.service;

import com.example.tasktracker.entities.User;
import com.example.tasktracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
	@Autowired
	private UserRepository repo;

	public User findOne(Long id) {
		return repo.findOne(id);
	}

	public Iterable<User> findAll() {
		return repo.findAll();
	}

	public User save(User user) {
		return repo.save(user);
	}

	public void delete(Long aLong) {
		repo.delete(aLong);
	}

	public boolean exists(Long id) {
		return repo.exists(id);
	}

}
