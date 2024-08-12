package com.example.BackendFleetOperations.user.service;

import com.example.BackendFleetOperations.user.model.User;
import com.example.BackendFleetOperations.user.model.UserRequestData;
import com.example.BackendFleetOperations.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save( User user ) {

        userRepository.save( user );
    }

    public boolean isUserExist(String userName) {

        return userRepository.existsByUserName( userName );
    }

    public void save(UserRequestData userRequestData) {

        User user = new User();

        user.setUserName( userRequestData.getUsername() );
        user.setPassword( userRequestData.getPassword() );

        save( user );
    }

    public Optional<User> findByUserName(String userName) {

        return userRepository.findByUserName( userName );
    }
}
