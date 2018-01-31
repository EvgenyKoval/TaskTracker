package com.example.tasktracker.controller;

import com.example.tasktracker.entities.Project;
import com.example.tasktracker.entities.Task;
import com.example.tasktracker.service.DeveloperService;
import com.example.tasktracker.service.ManagerService;
import com.example.tasktracker.service.ProjectService;
import com.example.tasktracker.service.TaskService;
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
	private ManagerService managerService;
	private DeveloperService developerService;
	private TaskService taskService;

	@GetMapping
	@ResponseBody
	public Iterable<Project> getProjects() {
		return projectService.findAll();
	}

	@PostMapping("/project")
	@ResponseStatus(HttpStatus.OK)
	public void addProject(@RequestParam("projectname") String projectName, @RequestParam("managerId") Long managerId) {
		Project project = context.getBean(Project.class);
		project.setProjectName(projectName);
		project.setManager(managerService.findOne(managerId));
		projectService.save(project);
	}

	@GetMapping("/project/{projectId}/tasks")
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
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	@Autowired
	public void setDeveloperService(DeveloperService developerService) {
		this.developerService = developerService;
	}

	@Autowired
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
}
