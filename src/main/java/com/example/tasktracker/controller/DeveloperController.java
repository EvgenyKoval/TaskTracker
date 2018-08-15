package com.example.tasktracker.controller;

import com.example.tasktracker.entities.Project;
import com.example.tasktracker.entities.Task;
import com.example.tasktracker.entities.User;
import com.example.tasktracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/developers")
public class DeveloperController {
	private UserService userService;

	@Autowired
	public DeveloperController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<Iterable<User>> getDevelopers() {
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		User user = userService.findOne(id);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		if (user.getId() == null || !userService.exists(user.getId())) {
			return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		if (userService.exists(id)) {
			return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeUser(@PathVariable Long id) {
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

//	@GetMapping("/{id}/tasks")
//	public ResponseEntity<Iterable<Task>> getUserTasks(@PathVariable Long id) {
//		return new ResponseEntity<>(userService.getTasks(id), HttpStatus.OK);
//	}
//
//	@GetMapping("/{id}/projects")
//	public ResponseEntity<Iterable<Project>> getUserProjects(@PathVariable Long id) {
//		return new ResponseEntity<>(userService.getProjects(id), HttpStatus.OK);
//	}


}
