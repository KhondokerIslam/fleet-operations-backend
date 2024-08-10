package com.example.BackendFleetOperations.enums;

import java.util.HashMap;
import java.util.Map;

public enum FuelType {

    BioLNG (0, "BioLNG"),
    LNG (1, "LNG"),
    HVO (2, "HVO"),
    B20 (3, "B20"),
    Electricity (4, "Electricity");

    private static Map<Integer,String> fuelTypeMap = new HashMap<Integer,String>();

    static {

        for (FuelType f : FuelType.values()) {

            fuelTypeMap.put(f.value, f.label);
        }
    }

    private final Integer value;
    private final String label;

    private FuelType(Integer value, String label) {

        this.value = value;
        this.label = label;
    }

    public String getLabel(Integer value) {

        return fuelTypeMap.get(value);
    }

}
