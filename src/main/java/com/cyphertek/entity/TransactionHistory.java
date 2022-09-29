package com.cyphertek.entity;

import com.cyphertek.enums.TransactionType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transaction_history")
@Data
public class TransactionHistory extends BaseEntity {

    @Column(name = "amount", nullable = false, columnDefinition = "decimal(10,2) default 0")
    private BigDecimal amount;

    @Column(name = "transaction_type", nullable = false, columnDefinition = "varchar(45)")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
