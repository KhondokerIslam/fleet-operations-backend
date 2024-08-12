package com.example.BackendFleetOperations.user.repository;

import com.example.BackendFleetOperations.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByUserName(String username);

    Optional<User> findByUserName(String username);
}
