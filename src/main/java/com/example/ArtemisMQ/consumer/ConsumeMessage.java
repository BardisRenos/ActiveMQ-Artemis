package com.example.ArtemisMQ.consumer;

import com.example.ArtemisMQ.entity.Customer;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.ObjectMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;


@Configuration
@Slf4j
public class ConsumeMessage implements MessageListener {

    @Override
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage)message;
            Customer customer = (Customer)objectMessage.getObject();

            log.info("Received Message(Customer Object) from Topic: "+ customer.toString());
        } catch(Exception e) {
            log.error("Received Exception while processing message: "+ e);
        }

    }
}