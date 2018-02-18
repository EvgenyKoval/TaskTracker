package com.example.tasktracker.controller;

import com.example.tasktracker.DataGenerator;
import com.example.tasktracker.entities.Comment;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

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
public class CommentControllerTest {
	private HttpMessageConverter mappingJackson2HttpMessageConverter;
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private DataGenerator dataGenerator;

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {
		this.mappingJackson2HttpMessageConverter = Arrays.stream(converters).
				filter(
						converter -> converter instanceof MappingJackson2HttpMessageConverter).
				findAny().get();
	}

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void findAll() throws Exception {
		mockMvc.perform(get("/comments"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", iterableWithSize(10)));
	}

	@Test
	public void deleteOne() throws Exception {
		mockMvc.perform(delete("/comments/comment/{id}", 10L))
				.andExpect(status().isOk());
	}


	@Test
	public void findById() throws Exception {
		mockMvc.perform(get("/comments/comment/{id}", 1L))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.commentId", is(1)));
	}

	@Test
	public void findByIdFailed() throws Exception {
		mockMvc.perform(get("/comments/comment/{id}", -1L))
				.andExpect(status().isNotFound());
	}

	@Test
	public void addOne() throws Exception {
		Comment comment = new Comment();
		comment.setCommentText("Test");
		mockMvc.perform(post("/comments/comment")
				.contentType(MediaType.APPLICATION_JSON)
				.param("authorId", "1")
				.param("commentText", "Test"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.commentText", is("Test")));
	}

	@Test
	public void updateOne() throws Exception {
		Comment comment = new Comment();
		comment.setCommentText("Test");
		comment.setDate(null);
		String commentJson = new Gson().toJson(comment);
		mockMvc.perform(put("/comments/comment/{id}", 1L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(commentJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.commentText", is("Test")));

		mockMvc.perform(put("/comments/comment/{id}", -1L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(commentJson))
				.andExpect(status().isNotFound());
	}

}