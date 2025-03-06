package com.example.spring_boot_foo_fighters.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {

    @NotBlank(message = "Имя не может быть пустым")   /// Сообщение в консоли
    private String firstName;

    @NotNull(message = "Возраст не может быть пустым")
    private Integer age;

    private Boolean isVerified;

    @NotBlank
    private String phoneNumber;
}
