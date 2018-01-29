package com.example.tasktracker.service;

import com.example.tasktracker.entities.Manager;
import com.example.tasktracker.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ManagerService {
	@Autowired
	private ManagerRepository repo;

	public Manager save(Manager manager) {
		return repo.save(manager);
	}

	public Iterable<Manager> save(Iterable<Manager> iterable) {
		return repo.save(iterable);
	}

	@Transactional
	public Manager findOne(Long id, boolean permanently) {
		Manager manager = repo.findOne(id);
		if (permanently) {
			manager.getCreatedProjects().size();
			manager.getCreatedTasks().size();
			manager.getComments().size();
		}
		return manager;
	}

	public boolean exists(Long aLong) {
		return repo.exists(aLong);
	}

	public Iterable<Manager> findAll() {
		return repo.findAll();
	}

	public Iterable<Manager> findAll(Iterable<Long> iterable) {
		return repo.findAll(iterable);
	}

	public long count() {
		return repo.count();
	}

	public void delete(Long aLong) {
		repo.delete(aLong);
	}

	public void delete(Manager manager) {
		repo.delete(manager);
	}

	public void delete(Iterable<Manager> iterable) {
		repo.delete(iterable);
	}

	public void deleteAll() {
		repo.deleteAll();
	}
}
