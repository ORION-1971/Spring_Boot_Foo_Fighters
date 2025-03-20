package com.example.spring_boot_foo_fighters.exception;

public class ServiceException extends RuntimeException {

    public ServiceException(ErrorCode errorCode,Object... args) {
        super(errorCode.format(args));
    }
}
