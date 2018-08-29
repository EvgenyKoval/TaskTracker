package com.example.tasktracker.service;

import com.example.tasktracker.entities.Project;
import com.example.tasktracker.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository repo;

	public Project save(Project project) {
		return repo.save(project);
	}

	public Iterable<Project> save(Iterable<Project> projects) {
		return repo.save(projects);
	}

	public Project findOne(Long id) {
		return repo.findOne(id);
	}

	public boolean exists(Long id) {
		return repo.exists(id);
	}

	public Iterable<Project> findAll() {
		return repo.findAll();
	}

	public Iterable<Project> findAll(Iterable<Long> iterable) {
		return repo.findAll(iterable);
	}

	public long count() {
		return repo.count();
	}

	public void delete(Long id) {
		repo.delete(id);
	}

	public void delete(Project project) {
		repo.delete(project);
	}

	public void delete(Iterable<? extends Project> iterable) {
		repo.delete(iterable);
	}

	public void deleteAll() {
		repo.deleteAll();
	}

	public Project findProjectWithTasks(Long id) {
		return null;
//		return repo.getProjectWithTasks();
	}

}
