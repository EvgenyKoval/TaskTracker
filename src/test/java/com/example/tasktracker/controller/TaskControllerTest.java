package com.example.tasktracker.controller;

import com.example.tasktracker.entities.Task;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TaskControllerTest {
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;


	@Before
	public void setUp() throws Exception {
		mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getTasks() throws Exception {
		mockMvc.perform(get("/tasks"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", iterableWithSize(1)));
	}

	@Test
	public void getTask() throws Exception {
		mockMvc.perform(get("/tasks/{id}", 1L))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.taskId", is(1)));
	}

	@Test
	public void addTask() throws Exception {
		mockMvc.perform(post("/tasks/")
				.contentType(MediaType.APPLICATION_JSON)
				.param("managerId", "1")
				.content(new Gson().toJson(new Task())))
				.andExpect(jsonPath("$.taskId", is(2)));
	}

	@Test
	public void updateTask() throws Exception {
		Task task = new Task();
		task.setTaskName("testName");
		mockMvc.perform(put("/tasks/{id}",1L)
		.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(task)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.taskId",is(1)))
				.andExpect(jsonPath("$.taskName",is("testName")));

	}

	@Test
	public void deleteTask() throws Exception {
		mockMvc.perform(delete("/tasks/{id}", 2L))
				.andExpect(status().isOk());
	}

}