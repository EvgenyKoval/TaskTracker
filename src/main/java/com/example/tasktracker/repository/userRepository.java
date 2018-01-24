package com.example.tasktracker.repository;

import com.example.tasktracker.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<User,Long> {
}
