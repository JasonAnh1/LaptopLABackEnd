package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductFilterStatus {
    TOP_SALE,
    TOP_FAVORITES,
    TOP_PROMOTION;

    @JsonValue
    public int toValue() {
        return ordinal();
    }

}
