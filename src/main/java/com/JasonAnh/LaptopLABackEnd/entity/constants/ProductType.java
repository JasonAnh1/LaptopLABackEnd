package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductType {
    HOT,
    FAVORITES,
    PROMOTION,
    HOT_AND_FAVORITES;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
