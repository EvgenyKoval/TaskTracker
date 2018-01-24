package com.example.tasktracker.repository;

import com.example.tasktracker.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Role,Long>{
}
