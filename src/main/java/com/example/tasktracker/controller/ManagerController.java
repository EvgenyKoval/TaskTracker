package com.example.tasktracker.controller;

import com.example.tasktracker.entities.Manager;
import com.example.tasktracker.entities.Project;
import com.example.tasktracker.entities.Task;
import com.example.tasktracker.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/managers")
public class ManagerController {
	private ManagerService managerService;

	@Autowired
	public ManagerController(ManagerService managerService) {
		this.managerService = managerService;
	}

	@GetMapping
	public ResponseEntity<Iterable<Manager>> getDevelopers() {
		return new ResponseEntity<>(managerService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/manager/{id}")
	public ResponseEntity<Manager> getManager(@PathVariable Long id) {
		Manager manager = managerService.findOne(id);
		if (manager != null) {
			return new ResponseEntity<>(manager, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/manager")
	public ResponseEntity<Manager> addManager(@RequestBody Manager manager) {
		if (!managerService.exists(manager.getId())) {
			return new ResponseEntity<>(managerService.save(manager), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/manager/{id}")
	public ResponseEntity<Manager> updateManager(@PathVariable Long id, @RequestBody Manager manager) {
		if (managerService.exists(id)) {
			return new ResponseEntity<>(managerService.save(manager), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/manager/{id}")
	public ResponseEntity<Void> removeManager(@PathVariable Long id) {
		managerService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/manager/{id}/tasks")
	public ResponseEntity<Iterable<Task>> getManagerTasks(@PathVariable Long id) {
		return new ResponseEntity<>(managerService.getTasks(id), HttpStatus.OK);
	}

	@GetMapping("/manager/{id}/projects")
	public ResponseEntity<Iterable<Project>> getManagerProjects(@PathVariable Long id) {
		return new ResponseEntity<>(managerService.getProjects(id), HttpStatus.OK);
	}



}
