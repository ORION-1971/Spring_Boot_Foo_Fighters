package com.example.spring_boot_foo_fighters.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
//@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class RestExceptionResponse {

    private final String uuid;
    private final LocalDateTime timestamp;
    private final Integer status;
    private final String path;
    private final String code;
    private final String message;

}
