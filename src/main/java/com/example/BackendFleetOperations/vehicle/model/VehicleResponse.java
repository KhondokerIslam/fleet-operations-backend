package com.example.BackendFleetOperations.vehicle.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VehicleResponse {

    private Long id;
    private String regNo;
    private String modelName;
}
