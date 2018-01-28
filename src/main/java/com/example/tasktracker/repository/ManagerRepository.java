package com.example.tasktracker.repository;

import com.example.tasktracker.entities.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends CrudRepository<Manager,Long> {
}
