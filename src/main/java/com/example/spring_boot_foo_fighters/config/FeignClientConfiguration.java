package com.example.spring_boot_foo_fighters.config;

import com.example.spring_boot_foo_fighters.client.MailSenderClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = {MailSenderClient.class})
public class FeignClientConfiguration {

}
