package com.example.BackendFleetOperations.enums;

import java.util.HashMap;
import java.util.Map;

public enum VehicleType {

    Truck (0, "Truck"),
    Car (1, "Car"),
    Bike (2, "Bike"),
    Pickup(3, "Pickup");

    private final Integer value;
    private final String label;

    VehicleType(Integer value, String label){

        this.value = value;
        this.label = label;
    }

    private static Map<Integer,String> vehicleTypeMap = new HashMap<Integer,String>();

    static {

        for (VehicleType vehicleType : VehicleType.values()) {

            vehicleTypeMap.put( vehicleType.value, vehicleType.label );
        }
    }
}
