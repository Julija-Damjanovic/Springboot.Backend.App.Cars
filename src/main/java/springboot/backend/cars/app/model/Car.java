package springboot.backend.cars.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Data
@Entity 
@Table(name = "cars")
public class Car {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name="car_make")
	private String carMake;
	
	@Column(name="car_model")
	private String carModel;
	
	@Column(name="year")
	private long year;
	
	public Car() {

	}

	public Car(long id, String carMake, String carModel,long year) {
		super();
		this.id = id;
		this.carMake = carMake;
		this.carModel = carModel;
		this.year=year;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	
	
	
	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	
	
	
	
}
