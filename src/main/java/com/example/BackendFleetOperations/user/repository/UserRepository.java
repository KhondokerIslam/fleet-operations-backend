package com.example.BackendFleetOperations.user.repository;

import com.example.BackendFleetOperations.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByUserName(String username);
}
