package com.cyphertek.enums;

public enum BTCTransactionType {

    BUY("BUY"), SALE("SALE");

    private String strValue;

    BTCTransactionType(String strValue) {
        this.strValue = strValue;
    }
}
