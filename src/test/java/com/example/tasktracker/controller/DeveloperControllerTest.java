package com.example.tasktracker.controller;

import com.example.tasktracker.entities.User;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeveloperControllerTest {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void getDevelopers() throws Exception {
		mockMvc.perform(get("/developers/"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", iterableWithSize(1)));
	}

	@Test
	public void getDeveloper() throws Exception {
		mockMvc.perform(get("/developers/{id}", 2L))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(2)));
	}

	@Test
	public void getMissingDeveloper() throws Exception {
		mockMvc.perform(get("/developers/{id}", -1L))
				.andExpect(status().isNotFound());
	}

	@Test
	public void addDeveloper() throws Exception {
		mockMvc.perform(post("/developers/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(new User())))
				.andExpect(status().isCreated())
		.andExpect(jsonPath("$.id",is(3)));
	}
	@Test
	public void addExistingDeveloper() throws Exception {
		User developer = new User();
		developer.setId(2L);
		mockMvc.perform(post("/developers/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(developer)))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void updateDeveloper() throws Exception {
		User dev = new User();
		dev.setName("testName");
		mockMvc.perform(put("/developers/{id}", 2L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(dev)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is("testName")));
	}
	@Test
	public void updateMissingDeveloper() throws Exception {
		mockMvc.perform(put("/developers/{id}", -1L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(new User())))
				.andExpect(status().isNotFound());
	}

	@Test
	public void deleteDeveloper() throws Exception {
		mockMvc.perform(delete("/developers/{id}",3L))
				.andExpect(status().isOk());
	}

	@Ignore
	@Test
	public void getDeveloperTasks() throws Exception {
		mockMvc.perform(get("/developers/{id}/tasks", 2L))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", iterableWithSize(1)));
	}

	@Ignore
	@Test
	public void getDeveloperProjects() throws Exception {
		mockMvc.perform(get("/developers/{id}/projects", 2L))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", iterableWithSize(1)));
	}

}