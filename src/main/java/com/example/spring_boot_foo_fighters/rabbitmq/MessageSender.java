package com.example.spring_boot_foo_fighters.rabbitmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    @Bean
    public Queue queue() {
        return new Queue("myQueue", false);
    }

    public void send(String message) {
        rabbitTemplate.convertAndSend("myQueue", message);
        log.info("Sent message: {}", message);
    }
}
