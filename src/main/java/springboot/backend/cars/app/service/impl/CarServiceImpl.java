package springboot.backend.cars.app.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import springboot.backend.cars.app.model.Car;
import springboot.backend.cars.app.repository.CarRepository;
import springboot.backend.cars.app.service.CarService;
import springboot.backend.cars.app.exception.*;

@Service
public class CarServiceImpl implements CarService{

	
	private CarRepository carRepository; 
	
	public CarServiceImpl(CarRepository carRespository) {
		super();
		this.carRepository = carRespository;
	}

	@Override
	public Car saveCar(Car car) {
	
		return carRepository.save(car);
	}
	public List<Car> getAllCars(){
		return carRepository.findAll();
	}

	public Car getCarById(long id) {
		return carRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Car","Id",id));
	}

	@Override
	public Car updateCar(Car car, long id) {
		Car existingCar = carRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Car","Id",id));
	
		existingCar.setCarMake(car.getCarMake());
		existingCar.setCarModel(car.getCarModel());
		existingCar.setYear(car.getYear());
		//save existing Car in DB
		carRepository.save(existingCar);
		return existingCar;
		
	}

	@Override
	public void deleteCar(long id) {
		 carRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Car","Id",id));
		 carRepository.deleteById(id);
	}
	
	
	
}
