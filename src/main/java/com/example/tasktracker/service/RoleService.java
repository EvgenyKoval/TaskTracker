package com.example.tasktracker.service;

import com.example.tasktracker.entities.Role;
import com.example.tasktracker.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
	@Autowired
	private RoleRepository repo;

	public Role save(Role role) {
		return repo.save(role);
	}

	public Role findOne(Long aLong) {
		return repo.findOne(aLong);
	}

	public boolean exists(Long aLong) {
		return repo.exists(aLong);
	}

	public Iterable<Role> findAll() {
		return repo.findAll();
	}

	public Iterable<Role> findAll(Iterable<Long> iterable) {
		return repo.findAll(iterable);
	}

	public long count() {
		return repo.count();
	}
}
