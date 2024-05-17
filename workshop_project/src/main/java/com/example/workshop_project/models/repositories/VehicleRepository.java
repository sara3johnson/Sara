package com.example.workshop_project.models.repositories;

import com.example.workshop_project.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
