package com.cyphertek.service;

import com.cyphertek.service.dto.ServiceResponse;
import com.cyphertek.service.dto.UserDTO;

public interface IUserService {

    ServiceResponse<UserDTO> createUser(UserDTO userDTO);

    ServiceResponse<Void> deleteUser(String userId);
}
