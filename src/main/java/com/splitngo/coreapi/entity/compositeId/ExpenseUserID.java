package com.splitngo.coreapi.entity.compositeId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Data
public class ExpenseUserID implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "id_expense")
    private Integer expenseId;

    @Column(name = "id_user")
    private Integer userId;

}