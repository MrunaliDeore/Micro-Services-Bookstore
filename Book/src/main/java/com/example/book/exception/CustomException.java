package com.example.book.exception;

public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}