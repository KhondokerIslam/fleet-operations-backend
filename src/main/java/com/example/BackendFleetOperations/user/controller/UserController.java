package com.example.BackendFleetOperations.user.controller;

import com.example.BackendFleetOperations.user.model.UserRequestData;
import com.example.BackendFleetOperations.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin( origins = "http://localhost:3000/")
@RestController
@RequestMapping( "/user" )
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping( "/signup" )
    public ResponseEntity<String> signup(
            @RequestBody UserRequestData userRequestData
    ) {

        System.out.println("Recieved Data: " + userRequestData);
        try {
            userService.save(userRequestData);
            return new ResponseEntity<>( "User Successfully saved. ", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping( "/login" )
    public ResponseEntity<String> login(
            @RequestBody UserRequestData userRequestData
    ) {

        try{
            userService.isUserExist( userRequestData.getUsername() );
            return new ResponseEntity<>( userRequestData.getUsername(), HttpStatus.OK);
        }
        catch (Exception e) {

            return new ResponseEntity<>( e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
