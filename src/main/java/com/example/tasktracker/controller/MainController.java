package com.example.tasktracker.controller;

import com.example.tasktracker.DataGenerator;
import com.example.tasktracker.entities.Role;
import com.example.tasktracker.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class MainController {
    @Autowired
    RoleRepository repository;

    public MainController(DataGenerator dataGenerator) {
        dataGenerator.generateData();
    }


    @GetMapping(value = "/")
    public String index(Model model) {
        Iterable<Role> all = repository.findAll();
        model.addAttribute("roles", all);
        return "greeting";
    }

//    @PostMapping("/login")
    public String login() {

        return "greeting";
    }


}
