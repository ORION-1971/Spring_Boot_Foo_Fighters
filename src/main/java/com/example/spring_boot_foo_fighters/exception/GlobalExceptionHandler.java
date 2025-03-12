package com.example.spring_boot_foo_fighters.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.rmi.ServerException;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotValidAgeException.class)
    public RestExceptionResponse handleNotValidAgeException(NotValidAgeException ex, HttpServletRequest request) {
        var processKey = UUID.randomUUID().toString();

        log.error("Service error, status: uuid: {}, message {}", processKey, ex.getMessage());

        return RestExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .code("1")
                .uuid(processKey)
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServerException.class)
    public RestExceptionResponse handleNotValidAgeException(ServerException ex, HttpServletRequest request) {
        var processKey = UUID.randomUUID().toString();

        log.error("Service error, status: uuid: {}, message {}", processKey, ex.getMessage());

        return RestExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Internal Server Error")
                .path(request.getRequestURI())
                .code("-1")
                .uuid(processKey)
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestExceptionResponse handleNotValidAgeException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        var processKey = UUID.randomUUID().toString();

        log.error("Service error, status: uuid: {}, message {}", processKey, ex.getMessage());

        return RestExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getFieldError().getDefaultMessage())
                .path(request.getRequestURI())
                .code("1")
                .uuid(processKey)
                .build();
    }
}
