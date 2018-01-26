package com.example.tasktracker.repository;

import com.example.tasktracker.entities.Project;
import com.example.tasktracker.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Set;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	List<User> findAllDevelopersByProjectId(Long aLong);
}
