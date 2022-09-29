package com.cyphertek.service.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class BTCTransactionDTO {
    @NotNull
    private BigDecimal coins;
    private String transactionType;
}
