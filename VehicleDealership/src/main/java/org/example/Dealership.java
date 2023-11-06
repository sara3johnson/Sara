package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private static ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> filteredVehicle = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getPrice() >= min && vehicle.getPrice()<= max){
    filteredVehicle.add(vehicle);
            }
        }
        return filteredVehicle;

    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model));
        }
        return filteredVehicles;

    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getYear() >= min && vehicle.getYear() <= max){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;

    }

    public List<Vehicle> getVehicleByColor(String color){
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getColor().equalsIgnoreCase(color)){
                filteredVehicles.add(vehicle);

            }
        }
    return filteredVehicles;

    }

    public List<Vehicle> getVehicleByMileage(int min, int max){
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }


    public List<Vehicle> getVehicleByType(String vehicleType){
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType));
            filteredVehicles.add(vehicle);

        }
        return filteredVehicles;
    }

    public static List<Vehicle> getAllVehicles(String allVehicles){
        return inventory;

    }

    public static List<Vehicle> addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
        return inventory;

    }

    public static List<Vehicle> removeVehicle(){
        inventory.remove(removeVehicle());
        return inventory;
    }

}


