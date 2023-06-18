package com.example.footbal_manager_fifa.exception;

public class ValidationException extends Exception {
    private String message;

    public ValidationException(String message) {
    }

    public String getMessage() {
        return message;
    }
}
