package com.everis.example.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import com.everis.example.config.ModelConfig;
import com.everis.example.config.ServiceConfig;
import com.everis.example.model.Car;
import com.everis.example.repository.CarRepository;
import com.everis.example.service.CarService;
import com.everis.example.service.CarServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { ServiceConfig.class, ModelConfig.class })
public class HelloControllerTest {

	@InjectMocks
	HelloController controller = new HelloController();

	@Spy
	@InjectMocks
	CarService service = new CarServiceImpl();

	@Mock
	CarRepository carRepository;

	@Mock
	View mockView;

	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(mockView).build();
	}

	@Test
	public void testGetHome() throws IllegalArgumentException, InvocationTargetException, Exception {
		when(carRepository.findAll()).thenReturn(getMockedList());

		mockMvc.perform(get("/home")).andExpect(status().isOk()).andExpect(model().attributeExists("carList"))
				.andExpect(view().name("home"));
	}

	private Iterable<Car> getMockedList() {

		return new ArrayList<Car>();
	}
}
