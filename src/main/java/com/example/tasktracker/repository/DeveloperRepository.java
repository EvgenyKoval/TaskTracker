package com.example.tasktracker.repository;

import com.example.tasktracker.entities.Developer;
import org.springframework.data.repository.CrudRepository;

public interface DeveloperRepository extends CrudRepository<Developer,Long> {
}
