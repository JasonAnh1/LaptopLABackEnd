package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum IdentifierRequestStatus {
    CREATE,
    ACCEPT,
    DENY;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
