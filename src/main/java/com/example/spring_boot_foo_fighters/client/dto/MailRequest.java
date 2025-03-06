package com.example.spring_boot_foo_fighters.client.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MailRequest {

    private String mailTo;

    private String subject;

    private String text;

    private EmployeeDto employeeDto;
}
