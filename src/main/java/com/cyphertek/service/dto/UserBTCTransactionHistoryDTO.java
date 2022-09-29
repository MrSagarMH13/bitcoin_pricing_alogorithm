package com.cyphertek.service.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class UserBTCTransactionHistoryDTO {
    private List<BTCTransactionHistoryDTO> transactions;
    private BigDecimal btc;
    private BigDecimal usd;
}
