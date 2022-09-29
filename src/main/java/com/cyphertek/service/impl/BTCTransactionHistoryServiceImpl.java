package com.cyphertek.service.impl;

import com.cyphertek.entity.BTCTransactionHistory;
import com.cyphertek.entity.User;
import com.cyphertek.enums.BTCTransactionType;
import com.cyphertek.enums.TransactionType;
import com.cyphertek.repository.BTCTransactionHistoryRepository;
import com.cyphertek.repository.UserRepository;
import com.cyphertek.service.IBTCTransactionHistoryService;
import com.cyphertek.service.ITransactionHistoryService;
import com.cyphertek.service.IUserService;
import com.cyphertek.service.dto.BTCTransactionDTO;
import com.cyphertek.service.dto.ServiceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

@Service
@Slf4j
public class BTCTransactionHistoryServiceImpl implements IBTCTransactionHistoryService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BTCTransactionHistoryRepository btcTransactionHistoryRepository;

    @Autowired
    ITransactionHistoryService transactionHistoryService;

    @Autowired
    IUserService userService;

    @Override
    public ServiceResponse<Void> btcTransactions(BTCTransactionDTO btcTransactionDTO, String userId) {
        log.info("=> btcTransactions STARTED");
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(User.class.getSimpleName() + "Not available for id :: " + userId));
        BTCTransactionHistory btcTransactionHistory = new BTCTransactionHistory();
        // TODO: Get the current BTC price from the data
        BigDecimal currentBTCPrice = BigDecimal.ONE;
        btcTransactionHistory.setCoins(btcTransactionDTO.getCoins());
        btcTransactionHistory.setBtcTransactionType(BTCTransactionType.valueOf(btcTransactionDTO.getTransactionType()));
        btcTransactionHistory.setUser(user);
        btcTransactionHistoryRepository.save(btcTransactionHistory);
        if (BTCTransactionType.valueOf(btcTransactionDTO.getTransactionType()).equals(BTCTransactionType.SALE))
            transactionHistoryService.creditToWallet(user, currentBTCPrice.multiply(btcTransactionDTO.getCoins()), TransactionType.BTCSALE);
        else if (BTCTransactionType.valueOf(btcTransactionDTO.getTransactionType()).equals(BTCTransactionType.BUY))
            transactionHistoryService.creditToWallet(user, currentBTCPrice.multiply(btcTransactionDTO.getCoins()), TransactionType.BTCPURCHASE);
        btcTransactionHistory.setPrice(currentBTCPrice.multiply(btcTransactionDTO.getCoins()));
        btcTransactionHistoryRepository.save(btcTransactionHistory);

        // Sync User wallet balance and BTC Coin Balance
        if (BTCTransactionType.valueOf(btcTransactionDTO.getTransactionType()).equals(BTCTransactionType.SALE))
            userService.syncUserWalletBalanceAndBTCBalance(user, currentBTCPrice.multiply(btcTransactionDTO.getCoins()), btcTransactionDTO.getCoins().multiply(BigDecimal.valueOf(-1)));
        else if (BTCTransactionType.valueOf(btcTransactionDTO.getTransactionType()).equals(BTCTransactionType.BUY))
            userService.syncUserWalletBalanceAndBTCBalance(user, currentBTCPrice.multiply(btcTransactionDTO.getCoins()).multiply(BigDecimal.valueOf(-1)), btcTransactionDTO.getCoins());

        ServiceResponse<Void> serviceResponse = new ServiceResponse<>();
        serviceResponse.setStatusCode(HttpStatus.OK);
        return serviceResponse;
    }
}
