package com.binary.services;

import com.binary.entities.Car;
import com.binary.repositories.CarRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements  CarService{

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public void createCar(Car car) {

    }

    @Override
    public void updateCar() {

    }

    @Override
    public void deleteCar() {

    }
}
