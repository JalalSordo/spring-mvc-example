package com.everis.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/home")
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView("home");

		mv.addObject("test", "hello world");
		return mv;
	}
}
