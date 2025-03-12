package com.example.spring_boot_foo_fighters.exception;


public class NotValidAgeException extends RuntimeException {
    public NotValidAgeException(String message) {
        super(message);
    }
}
