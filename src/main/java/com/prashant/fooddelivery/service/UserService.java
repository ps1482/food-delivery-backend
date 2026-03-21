package com.prashant.fooddelivery.service;

import com.prashant.fooddelivery.dto.UserResponseDTO;
import com.prashant.fooddelivery.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.prashant.fooddelivery.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// @Service Marks this class as a service layer component.
// Business logic should live here instead of controllers.
@Service
public class UserService {

    // Repository handles database operations
    private final UserRepository userRepository;

      // Constructor Injection: Industry standard for linking dependencies
      // Spring automatically injects UserRepository here
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    for Create Users (POST) API
//    This method saves the user in the database
    public UserResponseDTO createUser(User user) {
        //"Check if this email exists"
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            throw  new RuntimeException("Email already exists");
        }
        // save() method comes from JpaRepository
        User savedUser = userRepository.save(user);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(savedUser.getId());
        userResponseDTO.setEmail(savedUser.getEmail());
        userResponseDTO.setName(savedUser.getName());
        userResponseDTO.setRole(savedUser.getRole());

        return userResponseDTO;
    }

//    for Read Users (GET) API
    public List<UserResponseDTO> getAllUsers() {
        // 1. Fetch real entities from DB
        List<User> users = userRepository.findAll();

        // 2. Create a list to hold our safe DTOs
        List<UserResponseDTO> dtoList = new ArrayList<>();

        // 3. Loop through and convert each one
        for(User user : users) {
            UserResponseDTO dto = new UserResponseDTO();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            dto.setRole(user.getRole());

            dtoList.add(dto);
        }
        return dtoList;
    }

    public UserResponseDTO  getUserById(long id) {
        // 1. Ask the Repository for the user (The Assistant)
        // findById is built-in, so no need to change the Repository!
        User user =  userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id -" + id));

        // 2. Convert the Entity to a DTO (Manual Mapping)
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

}
