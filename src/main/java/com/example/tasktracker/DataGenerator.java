package com.example.tasktracker;

import com.example.tasktracker.entities.*;
import com.example.tasktracker.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataGenerator {

	private ConfigurableApplicationContext context;
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private TaskService taskService;


	public void generateData() {
		User manager = context.getBean(User.class);
		User dev = context.getBean(User.class);

		Role roleMan = context.getBean(Role.class);
		Role roleDev = context.getBean(Role.class);

		Task task = context.getBean(Task.class);
		Comment comment = context.getBean(Comment.class);
		Project project = context.getBean(Project.class);

		roleDev.setRoleName("Dev");

		roleService.save(roleDev);
		roleMan.setRoleName("manager");
		roleService.save(roleMan);

		manager.setRole(roleMan);
		dev.setRole(roleDev);

		task.setManager(manager);
		task.setProject(project);
		task.setDeveloper(dev);

		comment.setAuthor(manager);

		project.setManager(manager);
		project.addDeveloper(dev);
		project.addDeveloper(manager);

		userService.save(manager);
		userService.save(dev);
		projectService.save(project);
		taskService.save(task);
		commentService.save(comment);

		System.out.println(commentService.findOne(1L));
		System.out.println(roleService.findOne(1L));
		System.out.println(roleService.findOne(2L));
//		System.out.println(taskService.findOne(1L));
		System.out.println(userService.findOne(1L));
		System.out.println(userService.findOne(2L));

		Project project1 = projectService.findOne(1L);
//		Set<User> developers = projectService.findAllDevelopersByProjectId(1L);

		System.out.println();
		System.out.println(project1.getManager());
		System.out.println(project1.getPrijectName());
		System.out.println(project1.getProjectId());
		System.out.println(project1.getDevelopers().get(0));
//		System.out.println(project1);


	}


	@Autowired
	public void setContext(ConfigurableApplicationContext context) {
		this.context = context;
	}

}
