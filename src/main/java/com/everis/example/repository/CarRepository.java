package com.everis.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.everis.example.model.Car;

public interface CarRepository extends CrudRepository<Car, Long> {
	 
}