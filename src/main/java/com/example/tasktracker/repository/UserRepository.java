package com.example.tasktracker.repository;

import com.example.tasktracker.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
