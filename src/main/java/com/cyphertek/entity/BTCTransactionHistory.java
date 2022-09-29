package com.cyphertek.entity;

import com.cyphertek.enums.BTCTransactionType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "btc_transaction_history")
@Data
public class BTCTransactionHistory extends BaseEntity {

    @Column(name = "coins", nullable = false, columnDefinition = "decimal(10,2) default 0")
    private BigDecimal coins;

    @Column(name = "price", nullable = false, columnDefinition = "decimal(10,2) default 0")
    private BigDecimal price;

    @Column(name = "btc_transaction_type", nullable = false, columnDefinition = "varchar(45)")
    @Enumerated(EnumType.STRING)
    private BTCTransactionType btcTransactionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
