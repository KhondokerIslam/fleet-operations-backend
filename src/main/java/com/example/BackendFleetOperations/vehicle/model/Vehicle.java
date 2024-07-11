package com.example.BackendFleetOperations.vehicle.model;

import jakarta.persistence.*;
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

    @Column( name = "chassis_no" )
    private String chassisNo;

    @Column( name = "created_date" )
    private LocalDate createdDate;
}
