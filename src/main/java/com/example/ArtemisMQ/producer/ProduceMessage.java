package com.example.ArtemisMQ.producer;

import com.example.ArtemisMQ.entity.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProduceMessage {

    private final JmsTemplate jmsTemplate;

    @Value("${active-mq.topic}")
    private String TOPIC;

    public void sendMessage(Customer customer) {
        try{
            log.info("Attempting Send message to Topic: "+ TOPIC);
            jmsTemplate.convertAndSend(TOPIC, customer);
        } catch(Exception e) {
            log.error("Received Exception during send Message: ", e);
        }
    }
}
