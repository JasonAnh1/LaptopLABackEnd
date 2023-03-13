package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserAgentLevel {
    LEVEL_1,
    LEVEL_2,
    LEVEL_3,
    LEVEL_4,
    USER,
    ALl_LEVEL,
    ALL;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
