package com.example.ArtemisMQ.controller;

import com.example.ArtemisMQ.dto.CustomerDTO;
import com.example.ArtemisMQ.entity.Customer;
import com.example.ArtemisMQ.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Controller layer of User
 */
@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl userService;

    @GetMapping("customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getAllCustomers() {
        return userService.getAllCustomers();
    }

    @PostMapping("send")
    @ResponseStatus(HttpStatus.CREATED)
    public String sendItem(@RequestBody Customer customer) {

        return userService.sendItemCustomer(customer);
    }
}
