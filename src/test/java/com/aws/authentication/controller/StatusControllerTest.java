package com.aws.authentication.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//@RunWith(SpringRunner.class)
@WebMvcTest(controllers = StatusController.class)
public class StatusControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
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
