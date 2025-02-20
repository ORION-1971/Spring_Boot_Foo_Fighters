package com.example.spring_boot_foo_fighters.dto;

import lombok.Data;

@Data
public class UserDto {

    private String firstName;
    private Integer age;
    private Boolean isVerified;
    private String phoneNumber;
}
