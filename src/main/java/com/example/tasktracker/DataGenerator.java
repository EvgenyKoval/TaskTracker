package com.example.tasktracker;

import com.example.tasktracker.entities.*;
import com.example.tasktracker.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataGenerator {

    private ConfigurableApplicationContext context;
    @Autowired
    private UserService userService;
    @Autowired
    private DeveloperService developerService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private TaskService taskService;


    public void generateData() {
        Role roleMan = roleService.save(context.getBean(Role.class));
        Role roleDev = roleService.save(context.getBean(Role.class));
        roleDev.setRoleName("ROLE_DEV");
        roleService.save(roleDev);
        roleMan.setRoleName("ROLE_MANAGER");
        roleService.save(roleMan);
//		for (int i = 0; i < 10; i++) {
        Manager manager = managerService.save(context.getBean(Manager.class));
        Developer dev = developerService.save(context.getBean(Developer.class));

        Task task = taskService.save(context.getBean(Task.class));

        Comment comment = commentService.save(context.getBean(Comment.class));

        Project project = projectService.save(context.getBean(Project.class));

        manager.setRole(roleMan);
        manager.setEmail("");
        manager.setLogin("man");
        manager.setName("");
        manager.setPassword("123");

        dev.setRole(roleDev);
        dev.setLogin("dev");
        dev.setPassword("123");
        dev.setEmail("");
        dev.setName("");
        dev.setComments(new ArrayList<>());

        task.setManager(manager);
        task.setDeveloper(dev);
        task.setProject(project);

        comment.setAuthor(manager);

        project.setManager(manager);
        project.addDeveloper(dev);
        project.addTask(task);
        manager.addTask(task);
        manager.addProject(project);
        manager.addComment(comment);
        dev.addTask(task);
        dev.addProject(project);

        developerService.save(dev);
        managerService.save(manager);
        commentService.save(comment);
        projectService.save(project);
        taskService.save(task);
//		}
//        System.out.println(managerService.findAll());
        System.out.println(dev.getLogin() + " " + dev.getPassword());
//        System.out.println(commentService.findAll());
//        System.out.println(roleService.findAll());
//        System.out.println(taskService.findAll());
//        System.out.println(projectService.findAll());
    }

    public void clearDB() {
        commentService.deleteAll();
        taskService.deleteAll();
        developerService.deleteAll();
        projectService.deleteAll();
        managerService.deleteAll();
    }

    @Autowired
    public void setContext(ConfigurableApplicationContext context) {
        this.context = context;
    }

}
