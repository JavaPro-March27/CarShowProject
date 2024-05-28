package com.binary.services;

import com.binary.entities.Car;
import com.binary.repositories.CarRepository;
import com.binary.repositories.OwnerRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements  CarService{

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public Car createCar(Car car) {

        if(car == null){
            return null;
        }
        if(car.getOwner() != null && car.getOwner().getOwnerId() == null){
                ownerRepository.save(car.getOwner());
        }

       Car savedCar = carRepository.save(car);

        return savedCar;
    }




    @Override
    public Car updateCar(long id, Car updatedCar) {
        Optional<Car> optionalCar = carRepository.findById(id);

        if(optionalCar.isPresent()){
            if(updatedCar.getBrand() != null)
            optionalCar.get().setBrand(updatedCar.getBrand());
            if(updatedCar.getModel() != null)
            optionalCar.get().setModel(updatedCar.getModel());
            if(updatedCar.getColor() != null)
            optionalCar.get().setColor(updatedCar.getColor());
            if(updatedCar.getPrice() > 0)
            optionalCar.get().setPrice(updatedCar.getPrice());
            if(updatedCar.getYear() > 0)
            optionalCar.get().setYear(updatedCar.getYear());
            if(updatedCar.getOwner() != null)
            optionalCar.get().setOwner(updatedCar.getOwner());

            carRepository.save(optionalCar.get());
            return  optionalCar.get();
        }

        return null;
    }


    @Override
    public long deleteCar(long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if(optionalCar.isPresent()){
            carRepository.deleteById(id);
            return  id;
        }
        return 0;
    }



    @Override
    public Car getCarById(long id) {
        Optional<Car> car = carRepository.findById(id);
        if(car.isPresent()){
            return  car.get();
        }else{
            return  null;
        }
    }
}
