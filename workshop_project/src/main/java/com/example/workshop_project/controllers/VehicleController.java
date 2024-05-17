package com.example.workshop_project.controllers;

import com.example.workshop_project.models.Vehicle;
import com.example.workshop_project.models.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class VehicleController {
    private final VehicleServices vehicleServices;


    @Autowired
    public VehicleController(VehicleServices vehicleServices){
        this.vehicleServices = vehicleServices;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles(@ModelAttribute VehicleSearchCriteria searchCriteria) {
        return  new ResponseEntity<>(null);

    }

    //delete a vehicle method
    @DeleteMapping
    public ResponseEntity<Void> deleteVehicle(@PathVariable int id){
        this.vehicleServices.deleteVehicle(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //add a vehicle method
    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody @Valid Vehicle vehicle){

        Vehicle addedVehicle = this.vehicleServices.addVehicle(vehicle);
        return new ResponseEntity<>(addedVehicle, HttpStatus.CREATED);
    }



}
