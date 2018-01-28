package com.example.tasktracker.controller;

import com.example.tasktracker.service.ManagerService;
import com.example.tasktracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/")
public class ManagerController {
	@Autowired
	private UserService userService;

	@Autowired
	private ManagerService managerService;

	@GetMapping(value = "/users")
	public @ResponseBody
	String getAllUsers() {
		return managerService.findOne(1L).toString();
	}

	@GetMapping(value = "/user/{id}")
	public @ResponseBody
	String getManager(@PathVariable Long id) {
		return managerService.findOne(id).toString();
	}
}
