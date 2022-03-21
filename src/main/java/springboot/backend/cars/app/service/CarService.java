package springboot.backend.cars.app.service;

import java.util.List;

import springboot.backend.cars.app.model.Car;

public interface CarService {
   Car saveCar(Car car);
   List<Car> getAllCars();
   Car getCarById(long id);
   Car updateCar(Car car, long id);
   void deleteCar(long id);
}
