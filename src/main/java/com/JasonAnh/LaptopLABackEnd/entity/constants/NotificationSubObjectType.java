package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum NotificationSubObjectType {
    normal,
    chat,
    new_account,
    comment,
    user_level_up,
    has_user_level_up,
    order,
    event,
    ;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
