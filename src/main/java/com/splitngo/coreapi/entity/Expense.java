package com.splitngo.coreapi.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "expense")
@Data
public class Expense {

    // Initial attributes

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_expense")
    private Integer id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "cost", nullable = false)
    private int cost;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "is_forecast", nullable = false, columnDefinition = "BOOLEAN")
    private boolean isForecast;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updatedAt;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "update_by", nullable = false)
    private User updatedBy;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trip", nullable = false)
    private Trip trip;

    // Other fields and relationships

    @ToString.Exclude
    @OneToMany(mappedBy = "expense", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExpenseUser> expenseUsers;

    @ToString.Exclude
    @ManyToMany(mappedBy = "expenses")
    private List<Activity> activities;
}
