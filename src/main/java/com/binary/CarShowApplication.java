package com.binary;

import com.binary.entities.Car;
import com.binary.repositories.CarRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.logging.Logger;

@SpringBootApplication
public class CarShowApplication implements CommandLineRunner {

	@Autowired
	private CarRepository carRepository;


	public static void main(String[] args) {
		SpringApplication.run(CarShowApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
        Car car1 = new Car("Ford", "Mustand", "red", "xyz", 2024,56000);
		Car car2 = new Car("Nissan", "Leaf", "green", "anything", 2021,19500);
		Car car3 = new Car("Toyota", "Camry", "blue", "something", 2023,32000);
		Car car4 = new Car("Lexus", "ES 350", "white", "number", 2020,59000);

		carRepository.save(car1);
		System.out.println("Car 1 is saved");
        carRepository.saveAll(Arrays.asList(car2, car3, car4));
		System.out.println("rest of the Cars are saved");


		// Fetch all cars and print to console.
		carRepository.findAll().forEach(car -> System.out.println(car));

	}
}
