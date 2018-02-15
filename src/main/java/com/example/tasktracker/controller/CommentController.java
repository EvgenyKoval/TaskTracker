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
	private final UserService userService;
	private final ConfigurableApplicationContext context;

	public CommentController(CommentService commentService, UserService userService, ConfigurableApplicationContext context) {
		this.commentService = commentService;
		this.userService = userService;
		this.context = context;
	}

	@GetMapping(value = "/comment/{id}")
	@ResponseBody
	public ResponseEntity<Comment> getComments(@PathVariable Long id) {
		Comment comment = commentService.findOne(id);
		if (comment != null) {

			return new ResponseEntity<>(comment, HttpStatus.OK);
		} else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/comment")
	@ResponseStatus(HttpStatus.OK)
	public void addComment(@RequestParam("commentText") String commentText, @RequestParam("authorId") Long authorId) {
		Comment comment = context.getBean(Comment.class);
		comment.setAuthor(userService.findOne(authorId));
		comment.setCommentText(commentText);
		commentService.save(comment);
	}

	@DeleteMapping("/comment/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteComment(@PathVariable Long id) {
		commentService.delete(id);
	}

	@PutMapping("comment/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateComment(@PathVariable Long id, @RequestParam("commentText") String commentText) {
		Comment comment = commentService.findOne(id);
		comment.setCommentText(commentText);
		comment.setDate(new Date());
		commentService.save(comment);
	}

	@GetMapping
	@ResponseBody
	public Iterable<Comment> getComments() {
		return commentService.findAll();
	}
}
