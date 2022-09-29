package com.cyphertek.service;

import com.cyphertek.entity.User;
import com.cyphertek.service.dto.ServiceResponse;
import com.cyphertek.service.dto.UserDTO;

import java.math.BigDecimal;

public interface IUserService {

    ServiceResponse<UserDTO> createUser(UserDTO userDTO);

    ServiceResponse<Void> deleteUser(String userId);

    void syncUserWalletBalance(User user, BigDecimal transactionAmount);
}
