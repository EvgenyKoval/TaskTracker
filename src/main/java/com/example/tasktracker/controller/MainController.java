package com.example.tasktracker.controller;

import com.example.tasktracker.DataGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	public MainController(DataGenerator dataGenerator) {
		dataGenerator.generateData();
	}

	@GetMapping(value = "/")
	public @ResponseBody
	String test() {
		return "Test";
	}

}
