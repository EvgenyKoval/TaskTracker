package com.example.tasktracker.controller;

import com.example.tasktracker.entities.Comment;
import com.example.tasktracker.entities.User;
import com.example.tasktracker.service.CommentService;
import com.example.tasktracker.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	private final UserService userService;
	private final CommentService commentService;


	public UserController(UserService userService, CommentService commentService) {
		this.userService = userService;
		this.commentService = commentService;
	}

	@GetMapping
	@ResponseBody
	public Iterable<User> getAllUsers() {
		System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		return userService.findAll();
	}

	@GetMapping(value = "/user/{id}")
	@ResponseBody
	public User getManager(@PathVariable Long id) {
		return userService.findOne(id);
	}

	@DeleteMapping(value = "/user/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void deleteManager(@PathVariable Long id) {
		userService.delete(id);
	}

	/*@PostMapping(value = "/user")
	@ResponseStatus(HttpStatus.OK)
	public void addManager(@RequestParam("user") String manager) {
		userService.save(new Gson().fromJson(manager, Manager.class));
	}*/

	@GetMapping("/user/{id}/comments")
	@ResponseBody
	public Iterable<Comment> getUserComments(@PathVariable Long id) {
		return commentService.getUserComments(id);
	}
}
