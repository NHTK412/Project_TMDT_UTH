package com.example.clothingstore.exception.customer;

// 400
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
