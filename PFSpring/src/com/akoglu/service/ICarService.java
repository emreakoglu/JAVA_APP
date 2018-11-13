package com.akoglu.service;

import java.util.List;

import com.akoglu.model.Car;

public interface ICarService {
	
	List<Car> getAllCars();
	 
	void saveCar(final Car car);

}
