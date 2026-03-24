package com.prashant.fooddelivery.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.prashant.fooddelivery.model.User;
//import org.apache.catalina.User;

// * DTO (Data Transfer Object)
// * This class is just a carrier. It has no connection to the Database.
// * We use it to send data to the frontend WITHOUT the password.

// @Data -  Automatically generates Getters, Setters, toString, etc.
@Data
@NoArgsConstructor   // Creates a constructor with no arguments (needed by Spring)
@AllArgsConstructor  // Creates a constructor with ALL fields (id, name, email, role)
@JsonPropertyOrder({"id", "name", "email", "role"})  // for order of JSON in output
public class UserResponseDTO {
        private Long id;
        private String name;
        private String email;
        private String role;

        public UserResponseDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
            this.email = user.getEmail();
            this.role = user.getRole();

        }

}
