package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MobileDeviceStatus {
    off,
    on;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
