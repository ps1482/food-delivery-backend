package com.prashant.fooddelivery.exception;

/**
 * This is our custom "Signal." When the Service finds a duplicate email,
 * it throws this instead of a generic error.
 */
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}