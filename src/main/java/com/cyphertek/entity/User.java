package com.cyphertek.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;


@Entity
@Table(name = "user")
@Data
public class User extends BaseEntity {

    @Column(name = "first_name", nullable = false, columnDefinition = "varchar(100)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(100)")
    private String lastName;

    @Column(name = "email", nullable = false, columnDefinition = "varchar(255)")
    private String email;

    @Column(name = "wallet_balance", nullable = false, columnDefinition = "decimal(10,2) default 0")
    private BigDecimal walletBalance;

}
