package com.example.tasktracker.repository;

import com.example.tasktracker.entities.Manager;
import com.example.tasktracker.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	Iterable<Project> findAllByManager(Manager manager);
}
