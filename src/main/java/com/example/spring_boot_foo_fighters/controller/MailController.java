package com.example.spring_boot_foo_fighters.controller;

import com.example.spring_boot_foo_fighters.client.dto.MailRequest;
import com.example.spring_boot_foo_fighters.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class MailController {

    private final MailService mailService;

    @PostMapping
    public void sendMail(@RequestBody MailRequest mailRequest) {
        mailService.sendMail(mailRequest);
    }
}
