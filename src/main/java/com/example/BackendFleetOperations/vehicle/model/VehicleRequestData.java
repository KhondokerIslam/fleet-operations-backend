package com.example.BackendFleetOperations.vehicle.model;

import com.example.BackendFleetOperations.enums.FuelType;
import com.example.BackendFleetOperations.enums.VehicleType;
import lombok.Data;

@Data
public class VehicleRequestData {

    private Long id;
    private String regNo;
    private String modelName;
    private Integer vehicleSize; //In Tons
    private Integer purchaseYear;
    private Long purchaseCost;
    private Long dailyMaxTravelDistance; //In km
    private Long yearlyTravelRange; //In km
    private FuelType fuelType;
    private Double fuelConsumptionPerKm;
    private VehicleType vehicleType;
}
