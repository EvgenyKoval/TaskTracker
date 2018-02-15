package com.example.tasktracker.service;

import com.example.tasktracker.entities.Comment;
import com.example.tasktracker.entities.Manager;
import com.example.tasktracker.entities.Project;
import com.example.tasktracker.entities.Task;
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

	public Manager findOne(Long id) {
		return repo.findOne(id);
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

	@Transactional
	public Iterable<Project> getProjects(Long id) {
		return repo.findOne(id).getCreatedProjects();
	}

	@Transactional
	public Iterable<Task> getTasks(Long id) {
		return repo.findOne(id).getCreatedTasks();
	}

	@Transactional
	public Iterable<Comment> getComments(Long id) {
		return repo.findOne(id).getComments();
	}
}
