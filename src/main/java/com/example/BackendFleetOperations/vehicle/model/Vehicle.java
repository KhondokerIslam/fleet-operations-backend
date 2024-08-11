package com.example.BackendFleetOperations.vehicle.model;

import com.example.BackendFleetOperations.enums.FuelType;
import com.example.BackendFleetOperations.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table( name = "vehicle" )
@Data
public class Vehicle {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id" )
    private Long id;

    @Column( name = "reg_no" )
    private String regNo;

    @Column( name = "model_name" )
    private String modelName;

    @Column( name = "created_date" )
    private LocalDate createdDate;

    @Column( name = "vehicle_size" )
    private Integer vehicleSize; //In Tons

    @Column( name = "purchase_year" )
    private Integer purchaseYear;

    @Column( name = "purchase_cost" )
    private Long purchaseCost;

    @Column( name = "daily_max_travel_distance" )
    private Long dailyMaxTravelDistance; //In km

    @Column( name = "yearly_travel_range" )
    private Long yearlyTravelRange; //In km

    @Column( name = "fuel_type" )
    private FuelType fuelType;

    @Column( name = "fuel_consumption_per_km" )
    private Double fuelConsumptionPerKm;

    @Column( name = "available_from" )
    private LocalDate availableFrom = LocalDate.now();

    @Column( name = "vehicle_type" )
    private VehicleType vehicleType;
}
