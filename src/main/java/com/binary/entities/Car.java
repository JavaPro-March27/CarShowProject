package com.binary.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "car_table")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand , model ,color, registerNumber;
    private int year;
    @Column(name = "car_price")
    private double price;
    
    public Car(String brand, String model, String color, String registerNumber, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.year = year;
        this.price = price;
    }


}
