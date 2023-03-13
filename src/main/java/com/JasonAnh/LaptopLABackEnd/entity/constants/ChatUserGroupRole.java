package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChatUserGroupRole {
    MEMBER,
    ADMIN;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
