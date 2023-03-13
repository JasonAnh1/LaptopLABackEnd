package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BlogType {
    NEWS,
    VIDEO_YOUTUBE,
    TRAINING;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
