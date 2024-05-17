package com.example.workshop_project.models.services;

import com.example.workshop_project.models.Vehicle;
import com.example.workshop_project.models.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//the dffrnt search methods
//and crud functions
@Service
public class VehicleServices {
    //inject the repository into the service

    private final VehicleRepository vehicleRepository;


    @Autowired
    public VehicleServices(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    //delete a vehicle
    public void deleteVehicle(int vehicleId){
        var vehicle = this.vehicleRepository.findById(vehicleId);

        if(vehicle.isPresent()){
            this.vehicleRepository.delete(vehicle.get());
        }
    }


    public Vehicle addVehicle(Vehicle vehicle) {
        var newVehicle = this.vehicleRepository.save(vehicle);

        return this.vehicleRepository.save(vehicle);
    }

}
