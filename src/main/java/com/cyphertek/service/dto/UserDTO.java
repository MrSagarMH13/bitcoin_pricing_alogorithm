package com.cyphertek.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDTO {

    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
    private BigDecimal walletBalance;
    private BigDecimal btcBalance;
}
