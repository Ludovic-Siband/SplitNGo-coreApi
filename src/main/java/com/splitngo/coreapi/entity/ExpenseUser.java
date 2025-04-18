package com.splitngo.coreapi.entity;

import com.splitngo.coreapi.entity.compositeId.ExpenseUserID;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "expense_user")
@Data
public class ExpenseUser {

    @EmbeddedId
    private ExpenseUserID id = new ExpenseUserID();

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("expenseId")
    @JoinColumn(name = "id_expense", nullable = false)
    private Expense expense;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "is_paid", nullable = false, columnDefinition = "BOOLEAN")
    private boolean isPaid;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
