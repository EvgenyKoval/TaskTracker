package com.example.tasktracker.controller;

import com.example.tasktracker.entities.User;
import com.example.tasktracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/managers")
public class ManagerController {
	private UserService userService;

	@Autowired
	public ManagerController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<Iterable<User>> getDevelopers() {
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getManager(@PathVariable Long id) {
		User manager = userService.findOne(id);
		if (manager != null) {
			return new ResponseEntity<>(manager, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/")
	public ResponseEntity<User> addManager(@RequestBody User manager) {
		if (!userService.exists(manager.getId())) {
			return new ResponseEntity<>(userService.save(manager), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateManager(@PathVariable Long id, @RequestBody User manager) {
		if (userService.exists(id)) {
			return new ResponseEntity<>(userService.save(manager), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeManager(@PathVariable Long id) {
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

//	@GetMapping("/{id}/tasks")
//	public ResponseEntity<Iterable<Task>> getManagerTasks(@PathVariable Long id) {
//		return new ResponseEntity<>(userService.getTasks(id), HttpStatus.OK);
//	}
//
//	@GetMapping("/{id}/projects")
//	public ResponseEntity<Iterable<Project>> getManagerProjects(@PathVariable Long id) {
//		return new ResponseEntity<>(userService.getProjects(id), HttpStatus.OK);
//	}



}
