package com.cyphertek.service.transformer;

import com.cyphertek.entity.User;
import com.cyphertek.service.dto.UserDTO;

import java.math.BigDecimal;

public class UserTransformer extends Transformer<UserDTO, User> {

    public UserTransformer() {
        super(UserTransformer::covertToEntity, UserTransformer::convertToDTO);
    }

    public static UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUuid(user.getUuid());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setBtcBalance(user.getBtcBalance());
        userDTO.setWalletBalance(user.getWalletBalance());
        return userDTO;
    }

    public static User covertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setWalletBalance(BigDecimal.ZERO);
        return user;
    }
}
