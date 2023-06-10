package com.example.ArtemisMQ.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


/**
 * The entity class of the user database table
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", unique = true, nullable = false, updatable = false)
    private Integer customerID;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "balance")
    private Integer balance;

}
