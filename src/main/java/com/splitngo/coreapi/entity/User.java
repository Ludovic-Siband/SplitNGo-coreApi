package com.splitngo.coreapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {

    // Initial attributes

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @Column(name = "lastname", nullable = false, length = 255)
    private String lastName;

    @Column(name = "firstname", nullable = false, length = 255)
    private String firstName;

    @Column(name = "mail", nullable = false, unique = true, length = 255)
    private String mail;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "last_connection", nullable = false)
    private LocalDateTime lastConnection;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "BOOLEAN")
    private boolean isDeleted;

    // Other fields and relationships
    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "user_trip",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_trip")
    )
    private List<Trip> trips;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "user_activity",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_activity")
    )
    private List<Activity> activities;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "user_housing",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_housing")
    )
    private List<Housing> housings;

    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<ExpenseUser> expenseLinkToUser;

    @ToString.Exclude
    @OneToMany(mappedBy = "creator")
    private List<Trip> createdTrips;


}
