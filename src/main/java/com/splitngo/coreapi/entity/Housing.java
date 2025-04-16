package com.splitngo.coreapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "housing")
@Data
public class Housing {

    // Initial attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_housing")
    private Integer id;

    @Column(name = "type", nullable = false, length = 99)
    private String type;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "date_arrival", nullable = false)
    private LocalDateTime dateArrival;

    @Column(name = "date_departure", nullable = false)
    private LocalDateTime dateDeparture;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_expense", nullable = false)
    private Expense expense;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trip", nullable = false)
    private Trip trip;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contact", nullable = false)
    private Contact contact;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_address", nullable = false)
    private Address address;

    // Other fields and relationships
    @ToString.Exclude
    @ManyToMany(mappedBy = "housings")
    private List<User> users;
}
