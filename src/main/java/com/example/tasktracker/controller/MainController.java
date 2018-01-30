package com.example.tasktracker.controller;

import com.example.tasktracker.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
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
