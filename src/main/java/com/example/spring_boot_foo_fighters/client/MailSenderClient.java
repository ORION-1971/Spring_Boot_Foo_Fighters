package com.example.spring_boot_foo_fighters.client;

import com.example.spring_boot_foo_fighters.client.dto.MailRequest;
import com.example.spring_boot_foo_fighters.config.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "api-mail", url = "${api.url}", configuration = FeignClientConfiguration.class)
public interface MailSenderClient {

    @PostMapping("/mail")
    void sendMail(MailRequest mailRequest);
}
