package com.example.spring_boot_foo_fighters.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
//@AllArgsConstructor
public enum ErrorCode {

    AGE_NOT_VALID("Age must be less than 20"),
    NAME_NOT_VALID("Your name: %s length must be less than 15 symbols");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }

}
