package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum HiddenProfileField {
    PHONE,
    EMAIL,
    BIRTHDAY,
    GENDER;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
