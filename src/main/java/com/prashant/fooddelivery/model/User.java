package com.prashant.fooddelivery.model;

import jakarta.persistence.*;
import lombok.*;

//ENTITY LAYER: Represents the 'users' table in the database.
//We use JPA (Java Persistence API) to map this class to a table.

// * @Entity marks this class as a database entity.
// * Hibernate will create a table for this class.
@Entity

//Explicitly defining table name.
//Avoids SQL keyword conflicts.
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {

    // Primary Key for the table
    @Id

    // Auto increment id generation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// Using Wrapper 'Long' instead of primitive 'long' to allow nulls

    private String name;

    @Column(unique = true, nullable = false) // Pro tip: Database-level constraint for security
    private String email;

    private String password;
    private String role;  // e.g., CUSTOMER, DELIVERY_BOY, ADMIN
}
