package com.cyphertek.service;

import com.cyphertek.service.dto.BTCTransactionDTO;
import com.cyphertek.service.dto.ServiceResponse;

public interface IBTCTransactionHistoryService {
    ServiceResponse<Void> btcTransactions(BTCTransactionDTO btcTransactionDTO, String userId);
}
