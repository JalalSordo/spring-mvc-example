package com.everis.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.example.model.Car;
import com.everis.example.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarRepository carRepository;

	@Override
	public List<Car> list() {
		return (List<Car>) carRepository.findAll();
	}

}
