package springboot.backend.cars.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import springboot.backend.cars.app.model.Car;
import springboot.backend.cars.app.service.CarService;

@RestController
@RequestMapping("/api/c1")
public class CarController {

	private CarService carService;

	public CarController(CarService carService) {
		super();
		this.carService = carService;
	}
	//build create CAR REST API
	//http://localhost:8080/api/c1/cars
	@PostMapping("cars")
	public ResponseEntity<Car> saveCar(@RequestBody Car car){
		
		return new ResponseEntity<Car>(carService.saveCar(car),HttpStatus.CREATED);
		
	}

	@GetMapping
	//build get all car REST API
	public List<Car> getAllCars(){
		return carService.getAllCars();
	}
	// Build get car by id REST API
	//http://localhost:8080/api/c1/1 
	
	@GetMapping("{id}")
	public ResponseEntity<Car> getCarById(@PathVariable long id){
		
		
		return new ResponseEntity<Car>(carService.getCarById(id),HttpStatus.OK);
		
	}
	
	
	
	//build update car REST API 
	//http://localhost:8080/api/c1/1 
	@PutMapping("{id}")
	public ResponseEntity<Car> updateCar(@RequestBody Car car,@PathVariable("id") long id){
		return new ResponseEntity<Car>(carService.updateCar(car,id),HttpStatus.OK); 
	}
	
	//build delete car rest appi
	//http://localhost:8080/api/c1/5
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCar(@PathVariable("id")long id){
		carService.deleteCar(id);
		return new ResponseEntity<String>("Car deleted sucesfully",HttpStatus.OK);
	}
	
}