package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderType {
    DEFAULT,
    USER_PREFERENTIAL;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
