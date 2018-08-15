package com.example.tasktracker.controller;


import com.example.tasktracker.entities.Task;
import com.example.tasktracker.service.DeveloperService;
import com.example.tasktracker.service.ManagerService;
import com.example.tasktracker.service.ProjectService;
import com.example.tasktracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	private TaskService taskService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private DeveloperService developerService;
	@Autowired
	private ConfigurableApplicationContext context;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping
	public ResponseEntity<Iterable<Task>> getTasks() {
		return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Task> getTask(@PathVariable Long id) {
		if (taskService.exists(id)) {
			return new ResponseEntity<>(taskService.findOne(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public ResponseEntity<Task> addTask(@RequestBody Task task, @RequestParam("managerId") Long managerId) {
		task.setManager(managerService.findOne(managerId));
		Task save = taskService.save(task);
		System.out.println(save);
		return new ResponseEntity<>(save, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
		if (taskService.exists(id)) {
			Task one = taskService.findOne(id);
			one.setTaskName(task.getTaskName());
			return new ResponseEntity<>(taskService.save(one), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
		taskService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
