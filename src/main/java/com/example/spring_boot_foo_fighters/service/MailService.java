package com.example.spring_boot_foo_fighters.service;


import com.example.spring_boot_foo_fighters.client.MailSenderClient;
import com.example.spring_boot_foo_fighters.client.dto.MailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final MailSenderClient mailSenderClient;

    public void sendMail(MailRequest mailRequest) {
        mailSenderClient.sendMail(mailRequest);
    }
}
