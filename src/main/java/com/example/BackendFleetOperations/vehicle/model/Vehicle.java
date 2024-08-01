package com.example.BackendFleetOperations.vehicle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table( name = "vehicle" )
@Data
public class Vehicle {

    @Id
    //@GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id" )
    private Long id;

    @Column( name = "reg_no" )
    private String regNo;

    @Column( name = "model_name" )
    private String modelName;

    @Column( name = "created_date" )
    private LocalDate createdDate;
}
