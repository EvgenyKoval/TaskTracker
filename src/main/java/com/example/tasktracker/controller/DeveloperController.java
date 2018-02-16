package com.example.tasktracker.controller;

import com.example.tasktracker.entities.Developer;
import com.example.tasktracker.entities.Project;
import com.example.tasktracker.entities.Task;
import com.example.tasktracker.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/developers")
public class DeveloperController {
	private DeveloperService developerService;

	@Autowired
	public DeveloperController(DeveloperService developerService) {
		this.developerService = developerService;
	}

	@GetMapping
	public ResponseEntity<Iterable<Developer>> getDevelopers() {
		return new ResponseEntity<>(developerService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/developer/{id}")
	public ResponseEntity<Developer> getDeveloper(@PathVariable Long id) {
		Developer developer = developerService.findOne(id);
		if (developer != null) {
			return new ResponseEntity<>(developer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/developer")
	public ResponseEntity<Developer> addDeveloper(@RequestBody Developer developer) {
		if (!developerService.exists(developer.getId())) {
			return new ResponseEntity<>(developerService.save(developer), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/developer/{id}")
	public ResponseEntity<Developer> updateDeveloper(@PathVariable Long id, @RequestBody Developer developer) {
		if (developerService.exists(id)) {
			return new ResponseEntity<>(developerService.save(developer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/developer/{id}")
	public ResponseEntity<Void> removeDeveloper(@PathVariable Long id) {
		developerService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/developer/{id}/tasks")
	public ResponseEntity<Iterable<Task>> getDeveloperTasks(@PathVariable Long id) {
		return new ResponseEntity<>(developerService.getTasks(id), HttpStatus.OK);
	}

	@GetMapping("/developer/{id}/projects")
	public ResponseEntity<Iterable<Project>> getDeveloperProjects(@PathVariable Long id) {
		return new ResponseEntity<>(developerService.getProjects(id), HttpStatus.OK);
	}


}
