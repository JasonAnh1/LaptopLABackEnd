package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionType {
    TRANSACTION_PAYMENT_ONLINE, // = 0
    TRANSACTION_PAYMENT_WALLET, // = 1
    TRANSACTION_PAYMENT_RECHARGE, // = 2
    PAYMENT_METHOD_HOUSE, // = 3
    MAKE_BONUS, // = 4
    USE_BONUS,
    TRANSACTION_PAYMENT_WITHDRAW; // = 5

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
