package com.example.spring_boot_foo_fighters.sheduler;

import com.example.spring_boot_foo_fighters.client.dto.EmployeeDto;
import com.example.spring_boot_foo_fighters.client.dto.MailRequest;
import com.example.spring_boot_foo_fighters.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MailScheduler {

    private final MailService mailService;

    @Scheduled(cron = "* 3 14 * * *")              //https://crontab.guru/#*_0_14_*_*_*  каждый день в 14.00 - email //fixedRate = 5000
    public void sendMailAllUsers() {
        MailRequest mailRequest = MailRequest.builder()
                .mailTo("kandme@rambler.ru")
                .text("My First Scheduler Message !!!")
                .subject("URGENT!")
                .employeeDto(EmployeeDto.builder()
                        .id(4L)
                        .name("Gunay")
                        .surname("Hashimova")
                        .build())
                .build();

        mailService.sendMail(mailRequest);
        log.info("Mail is sended !!!");
    }
}
