package com.cyphertek.controller.api.v1;

import com.cyphertek.service.IBTCTransactionHistoryService;
import com.cyphertek.service.dto.BTCTransactionDTO;
import com.cyphertek.service.dto.ServiceResponse;
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
@RequestMapping("/api/v1/btc")
public class BTCController {

    @Autowired
    IBTCTransactionHistoryService transactionHistoryService;

    @PostMapping(value = "/transact/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ServiceResponse<Void>> btcTransactions(@Valid @RequestBody BTCTransactionDTO btcTransactionDTO, @Min(1) @PathVariable String userId) {
        ServiceResponse<Void> serviceResponse = transactionHistoryService.btcTransactions(btcTransactionDTO, userId);
        return new ResponseEntity<>(serviceResponse, serviceResponse.getStatusCode());
    }
}
