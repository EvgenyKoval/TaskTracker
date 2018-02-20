package com.example.tasktracker.controller;

import com.example.tasktracker.entities.Comment;
import com.example.tasktracker.service.CommentService;
import com.example.tasktracker.service.UserService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/comments")
public class CommentController {

	private final CommentService commentService;
	private final ConfigurableApplicationContext context;
	private UserService userService;

	public CommentController(CommentService commentService, ConfigurableApplicationContext context, UserService userService) {
		this.commentService = commentService;
		this.context = context;
		this.userService = userService;
	}

	@GetMapping(value = "/comment/{id}")
	public ResponseEntity<Comment> getComment(@PathVariable Long id) {
		Comment comment = commentService.findOne(id);
		if (comment != null) {
			return new ResponseEntity<>(comment, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/comment")
	public ResponseEntity<Comment> addComment(@RequestParam("authorId") Long authorId, @RequestBody Comment comment) {
		comment.setAuthor(userService.findOne(authorId));
		comment.setDate(new Date());
		Comment save = commentService.save(comment);
		return new ResponseEntity<>(save,HttpStatus.OK);
	}

	@DeleteMapping("/comment/{id}")
	public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
		commentService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("comment/{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
		if (commentService.exists(id)) {
			Comment one = commentService.findOne(id);
			one.setCommentText(comment.getCommentText());
			one.setDate(new Date());
			return new ResponseEntity<>(commentService.save(one), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public ResponseEntity<Iterable<Comment>> getComments() {
		return new ResponseEntity<>(commentService.findAll(), HttpStatus.OK);
	}
}
