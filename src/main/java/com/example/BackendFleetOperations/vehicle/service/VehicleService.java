package com.example.BackendFleetOperations.vehicle.service;

import com.example.BackendFleetOperations.utils.Utils;
import com.example.BackendFleetOperations.vehicle.model.Vehicle;
import com.example.BackendFleetOperations.vehicle.model.VehicleRequestData;
import com.example.BackendFleetOperations.vehicle.model.VehicleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public void save(Vehicle vehicle) {

        vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> findById(Long id) {

        return vehicleRepository.findById(id);
    }

    public VehicleResponse getVehicleResponseFromVehicle(Vehicle vehicle ) throws Exception {

        VehicleResponse vehicleResponse = getVehicleResponse(vehicle);

        if( vehicle.getId() == 1 ){

            throw new Exception("Cannot have one");
        }

        return vehicleResponse;
    }

    private static VehicleResponse getVehicleResponse(Vehicle vehicle) {

        return VehicleResponse.builder()
                .id( vehicle.getId() )
                .modelName( vehicle.getModelName() )
                .regNo( vehicle.getRegNo() )
                .vehicleSize( vehicle.getVehicleSize() )
                .purchaseYear( vehicle.getPurchaseYear() )
                .purchaseCost( vehicle.getPurchaseCost() )
                .dailyMaxTravelDistance( vehicle.getDailyMaxTravelDistance() )
                .yearlyTravelRange( vehicle.getYearlyTravelRange() )
                .fuelType( vehicle.getFuelType() )
                .fuelConsumptionPerKm( vehicle.getFuelConsumptionPerKm() )
                .availableFrom( vehicle.getAvailableFrom() )
                .vehicleType( vehicle.getVehicleType() )
                .isBooked(() -> {
                    LocalDate availableFromDate = Utils.makeDateStandard(vehicle.getAvailableFrom());
                    return availableFromDate.isBefore(LocalDate.now());
                })
                .build();
    }

    public List<VehicleResponse> getVehicleListFromVehicleResponses() {

        List<Vehicle> vehicles = vehicleRepository.findAll();

        return vehicles.stream().map(VehicleService::getVehicleResponse).toList();
    }

    public ResponseEntity<String> save(VehicleRequestData vehicleRequestData) {

        Vehicle vehicle = new Vehicle();

        if( vehicleRequestData.getId() != null ){

            vehicle = findById(vehicleRequestData.getId()).get();
        }
        try {

            vehicle.setModelName(vehicleRequestData.getModelName());
            vehicle.setRegNo(vehicleRequestData.getRegNo());
            vehicle.setCreatedDate( LocalDate.now() );
            vehicle.setVehicleSize( vehicleRequestData.getVehicleSize() );
            vehicle.setPurchaseYear( vehicleRequestData.getPurchaseYear() );
            vehicle.setPurchaseCost( vehicleRequestData.getPurchaseCost() );
            vehicle.setDailyMaxTravelDistance( vehicleRequestData.getDailyMaxTravelDistance() );
            vehicle.setYearlyTravelRange( vehicleRequestData.getYearlyTravelRange() );
            vehicle.setFuelType( vehicleRequestData.getFuelType() );
            vehicle.setFuelConsumptionPerKm( vehicleRequestData.getFuelConsumptionPerKm() );
            vehicle.setVehicleType( vehicleRequestData.getVehicleType() );

            save(vehicle);

            return new ResponseEntity<>("Vehicle added", HttpStatus.OK);
        }
        catch (Exception e) {

            e.printStackTrace();
            return new ResponseEntity<>("Vehicle Adding failed", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> delete(Long id) {

        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);

        try {
            vehicleRepository.delete(vehicleOptional.get());

            return new ResponseEntity<>("Vehicle deleted", HttpStatus.OK);
        }
        catch (Exception e) {

            e.printStackTrace();
            return new ResponseEntity<>("Vehicle deletion failed", HttpStatus.BAD_REQUEST);
        }

    }
}
