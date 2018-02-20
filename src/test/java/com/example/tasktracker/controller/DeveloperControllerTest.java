package com.example.tasktracker.controller;

import com.example.tasktracker.entities.Developer;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
		mockMvc.perform(get("/developers"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", iterableWithSize(10)));
	}

	@Test
	public void getDeveloper() throws Exception {
		mockMvc.perform(get("/developers/developer/{id}", 2L))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(2)));
	}

/*
	@Test
	public void addDeveloper() throws Exception {
		mockMvc.perform(post("/developers/developer")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(new Developer())))
				.andExpect(status().isOk())
		.andExpect(jsonPath("$.id",is(21)));
	}
*/

	@Test
	public void updateDeveloper() throws Exception {
	}

	@Test
	public void removeDeveloper() throws Exception {
	}

	@Test
	public void getDeveloperTasks() throws Exception {
	}

	@Test
	public void getDeveloperProjects() throws Exception {
	}

}