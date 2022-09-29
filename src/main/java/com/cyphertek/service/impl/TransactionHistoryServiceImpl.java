package com.cyphertek.service.impl;

import com.cyphertek.entity.TransactionHistory;
import com.cyphertek.entity.User;
import com.cyphertek.enums.TransactionType;
import com.cyphertek.repository.TransactionHistoryRepository;
import com.cyphertek.service.ITransactionHistoryService;
import com.cyphertek.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class TransactionHistoryServiceImpl implements ITransactionHistoryService {

    @Autowired
    TransactionHistoryRepository transactionHistoryRepository;

    @Override
    public void creditToWallet(User user, BigDecimal amount, TransactionType transactionType) {
        log.info("=> creditToWallet STARTED");
        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.setTransactionType(transactionType);
        transactionHistory.setAmount(amount);
        transactionHistory.setUser(user);
        transactionHistoryRepository.save(transactionHistory);
        log.info("=> creditToWallet END");
    }
}
