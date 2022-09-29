package com.cyphertek.service;

import com.cyphertek.common.exception.AccountException;
import com.cyphertek.service.dto.BTCTransactionDTO;
import com.cyphertek.service.dto.ServiceResponse;
import com.cyphertek.service.dto.UserBTCTransactionHistoryDTO;

import java.util.List;

public interface IBTCTransactionHistoryService {

    ServiceResponse<Void> btcTransactions(BTCTransactionDTO btcTransactionDTO, String userId) throws AccountException;

    ServiceResponse<UserBTCTransactionHistoryDTO> fetchTransactionsForUser(String userId);
}
