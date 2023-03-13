package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserLevelAgentStatus {
    WAITING,
    APPROVED,
    REJECTED;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
