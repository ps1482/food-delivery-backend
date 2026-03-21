package com.prashant.fooddelivery.repository;

import com.prashant.fooddelivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
 * Repository layer handles database operations.
 *
 * JpaRepository provides built-in methods:
 * save()
 * findAll()
 * findById()
 * deleteById()
 *
 * <User, Long> means:
 * Entity type: User
 * Primary key type: Long
 */
public interface UserRepository extends JpaRepository<User, Long> {
    // Spring will automatically create the SQL to find a user by email.
    Optional<User> findByEmail(String email);
}
