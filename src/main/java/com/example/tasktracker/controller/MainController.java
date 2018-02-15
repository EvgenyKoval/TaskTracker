package com.example.tasktracker.controller;

import com.example.tasktracker.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class MainController {

	public MainController(DataGenerator dataGenerator) {
		dataGenerator.generateData();
	}


	@GetMapping(value = "/")
	public String index() {
		return "greeting";
	}
}
