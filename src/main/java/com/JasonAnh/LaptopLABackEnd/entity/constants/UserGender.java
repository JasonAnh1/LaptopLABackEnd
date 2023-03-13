package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserGender {
    UNDEFINED,
    MAN,
    GIRL;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
