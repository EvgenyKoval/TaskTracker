package com.example.tasktracker.controller;

import com.example.tasktracker.entities.Manager;
import com.example.tasktracker.service.ManagerService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

//@Controller(value = "/users")
public class ManagerController {

	private ManagerService managerService;

	public ManagerController(ManagerService managerService) {
		this.managerService = managerService;
	}

	@GetMapping(value = "/")
	public @ResponseBody
	String getAllUsers() {
		return new Gson().toJson(managerService.findAll());
	}

	@GetMapping(value = "/user/{id}")
	public @ResponseBody
	String getManager(@PathVariable Long id) {
		Manager manager = managerService.findOne(id,true);
		return new Gson().toJson(manager,Manager.class);
	}

	@DeleteMapping(value = "/user/{id}")
	public @ResponseBody boolean deleteManager(@PathVariable Long id) {
		managerService.delete(id);
		return true;
	}

	@PostMapping(value = "/user")
	public String addManager(@RequestParam("manager") String manager, HttpServletResponse response) {
		managerService.save(new Gson().fromJson(manager,Manager.class));
		response.setStatus(200);
		return new Gson().toJson(true);
	}

}
