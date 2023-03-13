package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DiscountStatus {
    PREPARE,
    STARTING,
    ENDED;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
