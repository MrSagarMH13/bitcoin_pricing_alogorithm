package com.cyphertek.service.transformer;

import com.cyphertek.entity.BTCTransactionHistory;
import com.cyphertek.entity.TransactionHistory;
import com.cyphertek.service.dto.BTCTransactionHistoryDTO;
import com.cyphertek.service.dto.TransactionHistoryDTO;


public class BTCTransactionHistoryTransformer extends Transformer<BTCTransactionHistoryDTO, BTCTransactionHistory> {

    public BTCTransactionHistoryTransformer() {
        super(BTCTransactionHistoryTransformer::covertToEntity, BTCTransactionHistoryTransformer::convertToDTO);
    }

    public static BTCTransactionHistoryDTO convertToDTO(BTCTransactionHistory btcTransactionHistory) {
        BTCTransactionHistoryDTO btcTransactionHistoryDTO = new BTCTransactionHistoryDTO();
        return btcTransactionHistoryDTO;
    }

    public static BTCTransactionHistory covertToEntity(BTCTransactionHistoryDTO btcTransactionHistoryDTO) {
        BTCTransactionHistory btcTransactionHistory = new BTCTransactionHistory();
        return btcTransactionHistory;
    }
}
