package com.example.spring_boot_foo_fighters.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HumanDto {

    private String name;
    private int age;
}