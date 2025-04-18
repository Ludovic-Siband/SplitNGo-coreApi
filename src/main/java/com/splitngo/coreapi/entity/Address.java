package com.splitngo.coreapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Integer id;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "zip_code", nullable = false, length = 20)
    private String zipCode;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "country", nullable = false, length = 100)
    private String country;
}
