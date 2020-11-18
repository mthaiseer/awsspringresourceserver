package com.aws.authentication.controller;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * https://www.baeldung.com/spring-security-integration-tests
 * @author moham
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(StatusController.class)
@WebAppConfiguration
public class StatusControllerIntegrationTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@BeforeEach
	public void setup() {
		this.mvc = webAppContextSetup(context).apply(springSecurity()).build();
	}

	@WithMockUser(value = "spring")
	@Test
	public void sayHello_Success_IfTokenIsValid() throws Exception {
		mvc.perform(MockMvcRequestBuilders.request(
				HttpMethod.GET, "/api/status")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status()
						.isOk())
				.andExpect(content().string("working ...")
		);
	}

}
