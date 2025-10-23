package com.example.clothingstore.exception.customer;


// 404
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
