package com.splitngo.coreapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "activity")
@Data
public class Activity {

    // Initial attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_activity")
    private Integer id;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "date_start", nullable = false)
    private LocalDateTime dateStart;

    @Column(name = "date_end", nullable = false)
    private LocalDateTime dateEnd;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trip", nullable = false)
    private Trip trip;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address")
    private Address address;

    // Other fields and relationships

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "user_activity",
            joinColumns = @JoinColumn(name = "id_activity"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private List<User> members;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "activity_expense",
            joinColumns = @JoinColumn(name = "id_activity"),
            inverseJoinColumns = @JoinColumn(name = "id_expense")
    )
    private List<Expense> expenses;

    @ToString.Exclude
    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Media> medias;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "contact_activity",
            joinColumns = @JoinColumn(name = "id_activity"),
            inverseJoinColumns = @JoinColumn(name = "id_contact")
    )
    private List<Contact> contacts;
}