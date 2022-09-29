package com.cyphertek.service.transformer;

import com.cyphertek.entity.TransactionHistory;
import com.cyphertek.service.dto.TransactionHistoryDTO;


public class TransactionHistoryTransformer extends Transformer<TransactionHistoryDTO, TransactionHistory> {

    public TransactionHistoryTransformer() {
        super(TransactionHistoryTransformer::covertToEntity, TransactionHistoryTransformer::convertToDTO);
    }

    public static TransactionHistoryDTO convertToDTO(TransactionHistory transactionHistory) {
        TransactionHistoryDTO transactionHistoryDTO = new TransactionHistoryDTO();
        return transactionHistoryDTO;
    }

    public static TransactionHistory covertToEntity(TransactionHistoryDTO transactionHistoryDTO) {
        TransactionHistory transactionHistory = new TransactionHistory();
        return transactionHistory;
    }
}
