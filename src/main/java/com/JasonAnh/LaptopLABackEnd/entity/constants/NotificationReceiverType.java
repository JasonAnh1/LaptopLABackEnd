package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum NotificationReceiverType {
    ONE_USER,
    ALL_USER,
    AGENT_LEVEL,
    AGENT_LEVEL_1,
    AGENT_LEVEL_2,
    AGENT_LEVEL_3,
    AGENT_LEVEL_4,
    USER;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
