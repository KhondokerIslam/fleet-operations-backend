package com.example.BackendFleetOperations.vehicle.controller;

import com.example.BackendFleetOperations.vehicle.model.VehicleRequestData;
import com.example.BackendFleetOperations.vehicle.model.VehicleResponse;
import com.example.BackendFleetOperations.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin( origins = "http://localhost:3000/")
@RestController
@RequestMapping( "/api" )
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping( "/vehicles" )
    public List<VehicleResponse> vehicleList() {

        return vehicleService.getVehicleListFromVehicleResponses();
    }

    @PostMapping( "/vehicle" )
    public ResponseEntity<String> addVehicle(@RequestBody VehicleRequestData vehicleRequestData) {

        System.out.println("Recieved Data: " + vehicleRequestData);
        return vehicleService.save( vehicleRequestData );
    }

    @DeleteMapping( "/vehicle/{id}" )
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") Long id) {

        System.out.println( "Received ID: " + id );
        return vehicleService.delete( id );
    }
}