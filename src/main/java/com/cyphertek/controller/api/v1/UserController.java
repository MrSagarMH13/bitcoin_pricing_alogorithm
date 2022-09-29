package com.cyphertek.controller.api.v1;

import com.cyphertek.common.exception.AccountException;
import com.cyphertek.service.IBTCTransactionHistoryService;
import com.cyphertek.service.IUserService;
import com.cyphertek.service.dto.BTCTransactionDTO;
import com.cyphertek.service.dto.ServiceResponse;
import com.cyphertek.service.dto.UserBTCTransactionHistoryDTO;
import com.cyphertek.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    IBTCTransactionHistoryService transactionHistoryService;

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ServiceResponse<UserDTO>> createUser(@Valid @RequestBody UserDTO userDTO) {
        ServiceResponse<UserDTO> serviceResponse = userService.createUser(userDTO);
        return new ResponseEntity<>(serviceResponse, serviceResponse.getStatusCode());
    }

    @DeleteMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ServiceResponse<Void>> deleteUser(@Valid @PathVariable("userId") String userId) {
        ServiceResponse<Void> serviceResponse = userService.deleteUser(userId);
        return new ResponseEntity<>(serviceResponse, serviceResponse.getStatusCode());
    }

    @PostMapping(value = "/{userId}/btc-transaction", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ServiceResponse<Void>> btcTransactions(@Valid @RequestBody BTCTransactionDTO btcTransactionDTO, @PathVariable("userId") String userId) throws AccountException {
        ServiceResponse<Void> serviceResponse = transactionHistoryService.btcTransactions(btcTransactionDTO, userId);
        return new ResponseEntity<>(serviceResponse, serviceResponse.getStatusCode());
    }

    @GetMapping(value = "/{userId}/btc-transaction")
    public ResponseEntity<ServiceResponse<UserBTCTransactionHistoryDTO>> fetchTransactionsForUser(@Valid @PathVariable("userId") String userId) {
        ServiceResponse<UserBTCTransactionHistoryDTO> serviceResponse = transactionHistoryService.fetchTransactionsForUser(userId);
        return new ResponseEntity<>(serviceResponse, serviceResponse.getStatusCode());
    }
}
