package springboot.backend.cars.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import springboot.backend.cars.app.model.Car;
public interface CarRepository extends JpaRepository<Car,Long>{

}
