package com.example.tasktracker.repository;

import com.example.tasktracker.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

//    @Query("select p from Project p join fetch p.tasks")
//    Project getProjectWithTasks();
}
