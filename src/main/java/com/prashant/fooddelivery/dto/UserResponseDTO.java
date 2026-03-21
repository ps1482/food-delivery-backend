package com.prashant.fooddelivery.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// * DTO (Data Transfer Object)
// * This class is just a carrier. It has no connection to the Database.
// * We use it to send data to the frontend WITHOUT the password.

// @Data -  Automatically generates Getters, Setters, toString, etc.
@Data
@NoArgsConstructor   // Creates a constructor with no arguments (needed by Spring)
@AllArgsConstructor  // Creates a constructor with ALL fields (id, name, email, role)
public class UserResponseDTO {
        private Long id;
        private String name;
        private String email;
        private String role;

}
