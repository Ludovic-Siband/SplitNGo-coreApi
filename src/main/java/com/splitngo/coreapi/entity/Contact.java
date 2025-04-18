package com.splitngo.coreapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "contact")
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private Integer id;

    @Column(name = "lastname", nullable = false, length = 255)
    private String lastName;

    @Column(name = "firstname", nullable = false, length = 255)
    private String firstName;

    @Column(name = "mail", nullable = false, length = 255)
    private String mail;

    @Column(name = "phone", nullable = false, length = 20)
    private String phoneNumber;
}
