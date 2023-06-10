package com.example.ArtemisMQ.service;

import com.example.ArtemisMQ.dao.CustomerRepository;
import com.example.ArtemisMQ.dto.CustomerDTO;
import com.example.ArtemisMQ.entity.Customer;
import com.example.ArtemisMQ.mapper.CustomerMapper;
import com.example.ArtemisMQ.producer.ProduceMessage;
import com.example.ArtemisMQ.service.Interfaces.CustomerService;
import jakarta.jms.Destination;
import jakarta.jms.JMSProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;


/**
 * The Service layer of User
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ProduceMessage jmsProducer;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(CustomerMapper::toCustomerDTO).collect(Collectors.toList());
    }

    @Override
    @CachePut(cacheNames = "Customer", key="#customer.name")
    public String sendItemCustomer(Customer customer) {
        log.info("Message send: "+ customer.toString());
        Customer response = customerRepository.save(customer);
        jmsProducer.sendMessage(response);

        return "Sent successfully customer with the id: "+ response.getCustomerID();
    }
}

