package com.cyphertek.service.impl;

import com.cyphertek.enums.TransactionType;
import com.cyphertek.repository.UserRepository;
import com.cyphertek.entity.User;
import com.cyphertek.service.ITransactionHistoryService;
import com.cyphertek.service.IUserService;
import com.cyphertek.service.dto.ServiceResponse;
import com.cyphertek.service.dto.UserDTO;
import com.cyphertek.service.transformer.UserTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ITransactionHistoryService transactionService;

    @Value("${app.free-credit}")
    private BigDecimal freeCredit;

    @Override
    public ServiceResponse<UserDTO> createUser(UserDTO userDTO) {
        log.info("=> createUser STARTED");
        User user = new UserTransformer().convertFromDto(userDTO);
        userRepository.save(user);
        // This is getting called to credit the freebie
        transactionService.creditToWallet(user, freeCredit, TransactionType.WELCOMEBONUS);
        syncUserWalletBalance(user, freeCredit);
        return new ServiceResponse<UserDTO>().success(new UserTransformer().convertFromEntity(user));
    }

    @Override
    public ServiceResponse<Void> deleteUser(String userId) {
        log.info("=> deleteUser() STARTED");
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(User.class.getSimpleName() + "Not available for id :: " + userId));
        user.setActive(false);
        userRepository.save(user);
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setStatusCode(HttpStatus.NO_CONTENT);
        return serviceResponse;
    }

    @Override
    public void syncUserWalletBalance(User user, BigDecimal transactionAmount) {
        user.setWalletBalance(user.getWalletBalance().add(transactionAmount));
        userRepository.save(user);
    }
}
