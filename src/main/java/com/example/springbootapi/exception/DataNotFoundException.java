package com.example.springbootapi.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(Long id) {
        super("Data not found with " + id);
    }
}
