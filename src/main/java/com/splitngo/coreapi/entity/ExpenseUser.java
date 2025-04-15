package com.splitngo.coreapi.entity;

import com.splitngo.coreapi.entity.compositeId.ExpenseUserID;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "expense_user")
@Data
public class ExpenseUser {

    @EmbeddedId
    private ExpenseUserID id;

    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @MapsId("expenseId")
    @JoinColumn(name = "id_expense", nullable = false)
    private Expense expense;

    @Column(name = "is_paid")
    private boolean isPaid;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
