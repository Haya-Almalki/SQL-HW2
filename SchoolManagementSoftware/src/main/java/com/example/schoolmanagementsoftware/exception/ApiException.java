package com.example.schoolmanagementsoftware.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);
    }
}
