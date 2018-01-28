package com.example.tasktracker.controller;

import com.example.tasktracker.DataGenerator;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/1")
public class MainController {

	public MainController(DataGenerator dataGenerator) {
		dataGenerator.generateData();
	}

//	@GetMapping(value = "/")
//	public @ResponseBody
//	String index() {
//		return "Test";
//	}

}
