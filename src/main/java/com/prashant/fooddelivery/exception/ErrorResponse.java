package com.prashant.fooddelivery.exception;

/**
 * This is the clean JSON object the user will see.
 * We use a Record (Modern Java) to keep it simple and immutable.
 */
public record ErrorResponse(
        int status,
        String message,
        long timestamp
) {}