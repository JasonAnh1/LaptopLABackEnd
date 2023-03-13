package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentStatus {
    DEFAULT,
    SUCCESS,
    FAILED;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
