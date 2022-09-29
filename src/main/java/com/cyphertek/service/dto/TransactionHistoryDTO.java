package com.cyphertek.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionHistoryDTO {

    private String uuid;
    private BigDecimal amount;
    private String transactionType;
}
