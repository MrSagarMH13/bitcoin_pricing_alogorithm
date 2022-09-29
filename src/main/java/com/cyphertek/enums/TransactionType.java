package com.cyphertek.enums;

public enum TransactionType {

    RECHARGE("RECHARGE"), WELCOMEBONUS("WELCOMEBONUS"), BTCPURCHASE("BTCPURCHASE"), BTCSALE("BTCSALE");

    private String strValue;

    TransactionType(String strValue) {
        this.strValue = strValue;
    }
}
