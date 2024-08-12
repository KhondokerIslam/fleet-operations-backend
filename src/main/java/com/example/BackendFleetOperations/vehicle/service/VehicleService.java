package com.example.BackendFleetOperations.vehicle.service;

import com.example.BackendFleetOperations.user.model.User;
import com.example.BackendFleetOperations.user.service.UserService;
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

    @Autowired
    private UserService userService;

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

        VehicleResponse vehicleResponse = new VehicleResponse();

        vehicleResponse.setId( vehicle.getId() );
        vehicleResponse.setModelName( vehicle.getModelName() );
        vehicleResponse.setRegNo( vehicle.getRegNo() );
        vehicleResponse.setVehicleSize( vehicle.getVehicleSize() );
        vehicleResponse.setPurchaseYear( vehicle.getPurchaseYear() );
        vehicleResponse.setPurchaseCost( vehicle.getPurchaseCost() );
        vehicleResponse.setDailyMaxTravelDistance( vehicle.getDailyMaxTravelDistance() );
        vehicleResponse.setYearlyTravelRange( vehicle.getYearlyTravelRange() );
        vehicleResponse.setFuelType( vehicle.getFuelType() );
        vehicleResponse.setFuelConsumptionPerKm( vehicle.getFuelConsumptionPerKm() );
        vehicleResponse.setAvailableFrom( vehicle.getAvailableFrom() );
        vehicleResponse.setVehicleType( vehicle.getVehicleType() );
        vehicleResponse.setIsBooked( vehicle.getAvailableFrom() );

        return vehicleResponse;
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

            Optional<User> userOptional = userService.findByUserName( vehicleRequestData.getUserName() );

            if( userOptional.isPresent() ){

                User user = userOptional.get();
                vehicle.setUser( user );
            }

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
