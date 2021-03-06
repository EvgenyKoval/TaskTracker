package com.example.tasktracker;

import com.example.tasktracker.entities.*;
import com.example.tasktracker.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

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
        Role roleMan = roleService.save(new Role());
        Role roleDev = roleService.save(new Role());
        roleDev.setRoleName("ROLE_DEV");
        roleService.save(roleDev);
        roleMan.setRoleName("ROLE_MANAGER");
        roleService.save(roleMan);
//		for (int i = 0; i < 10; i++) {
        User manager = userService.save(new User());
        User dev = userService.save(new User());

        Task task = taskService.save(new Task());

        Comment comment = commentService.save(new Comment());

        Project project = projectService.save(new Project());

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

        task.setManager(manager);
        task.setDeveloper(dev);
        task.setProject(project);

        comment.setAuthor(manager);

        project.setManager(manager);
        commentService.save(comment);
        projectService.save(project);
        taskService.save(task);

        userService.save(manager);
        userService.save(dev);

//        System.out.println(manager);
//        System.out.println(dev);
//        System.out.println(comment);
//        System.out.println(project);
//        System.out.println(task);
//        System.out.println(roleMan);
//        System.out.println(roleDev);
//        System.out.println(projectService.findProjectWithTasks(1L));
        System.out.println();
//		}
//        System.out.println(managerService.findAll());
        System.out.println(dev.getLogin() + " " + dev.getPassword());
//        System.out.println(commentService.findAll());
//        System.out.println(roleService.findAll());
//        System.out.println(taskService.findAll());
//        System.out.println(projectService.findAll());
    }

    public void clearDB() {
        userService.findAll();
        commentService.deleteAll();
        taskService.deleteAll();
        projectService.deleteAll();
    }

    @Autowired
    public void setContext(ConfigurableApplicationContext context) {
        this.context = context;
    }

}
