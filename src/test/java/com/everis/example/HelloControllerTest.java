package com.everis.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.everis.example.controllers.HelloController;

public class HelloControllerTest {

	@Test
	public void testHelloController() {
		HelloController c = new HelloController();
		ModelAndView mav = c.homePage();
		assertEquals("home", mav.getViewName());

	}
}
