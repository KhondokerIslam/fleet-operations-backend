package com.example.BackendFleetOperations.vehicle.model;

import com.example.BackendFleetOperations.enums.FuelType;
import com.example.BackendFleetOperations.enums.VehicleType;
import com.example.BackendFleetOperations.utils.Utils;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VehicleResponse {

    private Long id;
    private String regNo;
    private String modelName;
    private Integer vehicleSize; //In Tons
    private Integer purchaseYear;
    private Long purchaseCost;
    private Long dailyMaxTravelDistance; //In km
    private Long yearlyTravelRange; //In km
    private Integer fuelType;
    private Double fuelConsumptionPerKm;
    private LocalDate availableFrom;
    private Integer vehicleType;
    private Boolean isBooked;

    public void setFuelType(FuelType fuelType) {

        this.fuelType = FuelType.getValueByName( fuelType );
    }

    public void setVehicleType(VehicleType vehicleType) {

        this.vehicleType = VehicleType.getValueByName( vehicleType );

    }

     public void setIsBooked(LocalDate availableFromDate) {

        availableFrom = Utils.makeDateStandard(availableFromDate);

         this.isBooked = availableFromDate.isBefore(LocalDate.now());
     }
}
