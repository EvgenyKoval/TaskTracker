package com.example.tasktracker.controller;

import com.example.tasktracker.entities.Project;
import com.example.tasktracker.entities.Task;
import com.example.tasktracker.service.ProjectService;
import com.example.tasktracker.service.TaskService;
import com.example.tasktracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	private ProjectService projectService;
	private ConfigurableApplicationContext context;
	private UserService userService;
	private TaskService taskService;

	@GetMapping
	@ResponseBody
	public Iterable<Project> getProjects() {
		return projectService.findAll();
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public void addProject(@RequestParam("projectname") String projectName, @RequestParam("managerId") Long managerId) {
		Project project = context.getBean(Project.class);
		project.setProjectName(projectName);
		project.setManager(userService.findOne(managerId));
		projectService.save(project);
	}

	@GetMapping("/{projectId}/tasks")
	@ResponseBody
	public Iterable<Task> getProjectTasks(@PathVariable Long projectId) {
		return taskService.getProjectTasks(projectId);
	}


	@Autowired
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@Autowired
	public void setContext(ConfigurableApplicationContext context) {
		this.context = context;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
}
