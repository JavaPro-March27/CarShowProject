package com.binary.services;

import com.binary.entities.Car;
import org.hibernate.sql.Update;

import java.util.List;

public interface CarService {

    public List<Car> getAllCars();
    public void  createCar(Car car);
    public void updateCar();
    public void deleteCar();
}
