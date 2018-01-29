package com.example.tasktracker.controller;

import com.example.tasktracker.entities.Comment;
import com.example.tasktracker.service.CommentService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {

	private CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping(value = "/comment/{id}")
	public @ResponseBody String getComments(@PathVariable Long id) {
		return new Gson().toJson(commentService.findOne(id));
	}
}
