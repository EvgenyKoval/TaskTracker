package com.example.tasktracker.service;

import com.example.tasktracker.entities.Task;
import com.example.tasktracker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskService {
	@Autowired
	private TaskRepository repo;

	public Task save(Task s) {
		return repo.save(s);
	}

	public Iterable<Task> save(Iterable<Task> iterable) {
		return repo.save(iterable);
	}

	public Task findOne(Long aLong) {
		return repo.findOne(aLong);
	}

	public boolean exists(Long aLong) {
		return repo.exists(aLong);
	}

	public Iterable<Task> findAll() {
		return repo.findAll();
	}

	public Iterable<Task> findAll(Iterable<Long> iterable) {
		return repo.findAll(iterable);
	}

	public long count() {
		return repo.count();
	}

	public void delete(Long aLong) {
		repo.delete(aLong);
	}

	public void delete(Task task) {
		repo.delete(task);
	}

	public void delete(Iterable<Task> iterable) {
		repo.delete(iterable);
	}

	public void deleteAll() {
		repo.deleteAll();
	}

	public Iterable<Task> getProjectTasks(Long projectId) {
		return repo.findAllByProjectProjectId(projectId);
	}
}
