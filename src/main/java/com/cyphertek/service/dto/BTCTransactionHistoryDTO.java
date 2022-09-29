package com.cyphertek.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BTCTransactionHistoryDTO {
    private String uuid;
    private BigDecimal coins;
    private BigDecimal price;
    private String btcTransactionType;
}
