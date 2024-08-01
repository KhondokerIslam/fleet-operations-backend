package com.example.BackendFleetOperations.vehicle.model;

import lombok.Data;

@Data
public class VehicleRequestData {

    private Long id;
    private String regNo;
    private String modelName;
}
