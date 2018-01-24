package com.example.tasktracker.repository;

import com.example.tasktracker.entities.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository  extends CrudRepository<Comment,Long> {
}
