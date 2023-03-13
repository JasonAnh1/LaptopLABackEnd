package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductStatus {
    COMING_SOON,
    ON_SALE,
    STOP_SALE,
    PENDING,
    HIDE;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
