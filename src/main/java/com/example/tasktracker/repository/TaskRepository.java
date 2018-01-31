package com.example.tasktracker.repository;

import com.example.tasktracker.entities.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,Long>{
	Iterable<Task> findAllByProjectProjectId(Long projectId);
}
