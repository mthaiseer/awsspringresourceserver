package com.aws.authentication.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;

//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = StatusController.class)
//@AutoConfigureMockMvc
public class StatusControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	
	@BeforeEach
	public void setup() {
	mockMvc = MockMvcBuilders
	                .webAppContextSetup(context)
	                .apply(springSecurity())
	                .build();
	}
	
	@Test
	void testStatusController() throws Exception {
		
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.get("/api/status")
				.accept(MediaType.APPLICATION_JSON);
			
			mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("working...."))
				.andReturn();

	}


}
