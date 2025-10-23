package com.example.clothingstore.exception.customer;

// 500
public class ServerErrorException extends RuntimeException {
    public ServerErrorException(String message) {
        super(message);
    }
}
