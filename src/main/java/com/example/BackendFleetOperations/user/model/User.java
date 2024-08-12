package com.example.BackendFleetOperations.user.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "user" )
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Long id;

    @Column( name = "user_name" )
    private String userName;

    @Column( name = "password" )
    private String password;
}
