package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BlogStatus {
    DEFAULT,
    HOT;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
