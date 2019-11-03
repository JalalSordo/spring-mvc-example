package com.everis.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.everis.example.model.Car;
import com.everis.example.service.CarService;

@Controller
public class HelloController {

	@Autowired
	protected CarService carService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		List<Car> carList = carService.list();
		mv.addObject("carList", carList);
		return mv;
	}
}
