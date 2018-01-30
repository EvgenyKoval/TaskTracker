package com.example.tasktracker.controller;

import com.example.tasktracker.entities.Comment;
import com.example.tasktracker.service.CommentService;
import com.example.tasktracker.service.UserService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comments")
public class CommentController {

	private CommentService commentService;
	private UserService userService;
	private ConfigurableApplicationContext context;

	public CommentController(CommentService commentService, UserService userService, ConfigurableApplicationContext context) {
		this.commentService = commentService;
		this.userService = userService;
		this.context = context;
	}

	@GetMapping(value = "/comment/{id}")
	@ResponseBody
	public Comment getComments(@PathVariable Long id) {
		return commentService.findOne(id);
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
	public void deleteComment(@PathVariable Long id) {
		commentService.delete(id);
	}

	@PutMapping("comment/{id}")
	public void updatecomment(@PathVariable Long id, @RequestParam Comment comment) {
		commentService.save(comment);
	}

	@GetMapping("/")
	public @ResponseBody
	Iterable<Comment> getComments() {

		return commentService.findAll();
	}
}
