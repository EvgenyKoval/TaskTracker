package com.example.tasktracker.service;

import com.example.tasktracker.entities.Comment;
import com.example.tasktracker.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentService {
	@Autowired
	private CommentRepository repo;

	public Comment save(Comment comment) {
		return repo.save(comment);
	}

	public Iterable<Comment> save(Iterable<Comment> iterable) {
		return repo.save(iterable);
	}

	public Comment findOne(Long id) {
		return repo.findOne(id);
	}

	public boolean exists(Long id) {
		return repo.exists(id);
	}

	public Iterable<Comment> findAll() {
		return repo.findAll();
	}

	public Iterable<Comment> findAll(Iterable<Long> iterable) {
		return repo.findAll(iterable);
	}

	public long count() {
		return repo.count();
	}

	public void delete(Long aLong) {
		repo.delete(aLong);
	}

	public void delete(Comment comment) {
		repo.delete(comment);
	}

	public void delete(Iterable<Comment> iterable) {
		repo.delete(iterable);
	}

	public void deleteAll() {
		repo.deleteAll();
	}

	public Iterable<Comment> getUserComments(Long id) {
		return repo.findAllByAuthorId(id);
	}
}
