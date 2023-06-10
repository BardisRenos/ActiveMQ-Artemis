package com.example.ArtemisMQ.dao;

import com.example.ArtemisMQ.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The Repository layer of User
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
