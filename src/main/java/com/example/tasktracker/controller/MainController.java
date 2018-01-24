package com.example.tasktracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping(value = "/")
	public @ResponseBody String test() {
		return "Test";
	}

}
