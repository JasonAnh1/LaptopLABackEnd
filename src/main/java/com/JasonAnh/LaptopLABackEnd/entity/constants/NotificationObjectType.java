package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum NotificationObjectType {
    normal,
    new_account,
    chat,
    news,
    order,
    level,
    event,
    ;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
