package com.example.tasktracker.controller;

import com.example.tasktracker.entities.Manager;
import com.example.tasktracker.entities.User;
import com.example.tasktracker.service.UserService;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	@ResponseBody
	public Iterable<User> getAllUsers() {
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

	@PostMapping(value = "/user")
	@ResponseStatus(HttpStatus.OK)
	public void addManager(@RequestParam("user") String manager) {
		userService.save(new Gson().fromJson(manager, Manager.class));
	}

}
