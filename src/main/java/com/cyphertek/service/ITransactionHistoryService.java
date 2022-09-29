package com.cyphertek.service;

import com.cyphertek.entity.User;
import com.cyphertek.enums.TransactionType;

import java.math.BigDecimal;

public interface ITransactionHistoryService {
    void creditToWallet(User user, BigDecimal freeCredit, TransactionType type);
}
