package com.example.ArtemisMQ.service.Interfaces;

import com.example.ArtemisMQ.dto.CustomerDTO;
import com.example.ArtemisMQ.entity.Customer;

import java.util.List;

/**
 * The User Service Interface. All methods that User Service has.
 */
public interface CustomerService {
    List<CustomerDTO> getAllCustomers();

    String sendItemCustomer(Customer customer);
}
