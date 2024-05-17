package com.example.workshop_project.models;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    @NotBlank
    private int vin;
    private int year;
    private String make;
    private String model;
    private String color;
    private String vehicleType;
    private int odometer;
    private double price;

    @ManyToMany(mappedBy = "vehicles")
    private Set<Dealership> dealership = new HashSet<>();


    public Vehicle(){

    }


    public Vehicle(int vin, int year, String make, String model, String color, String vehicleType, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.vehicleType = vehicleType;
        this.odometer = odometer;
        this.price = price;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Set<Dealership> getDealership() {
        return dealership;
    }

    public void setDealership(Set<Dealership> dealership) {
        this.dealership = dealership;
    }

    @Override
    public String toString() {
        return "VIN: " + vin +
                ", Year: " + year +
                ", Make: " + make +
                ", Model: " + model +
                ", Type: " + vehicleType +
                ", Color: " + color +
                ", Odometer: " + odometer +
                ", Price: " + price;


    }
}


