package com.JasonAnh.LaptopLABackEnd.entity.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum  BannerObjectType {
    NORMAL,
    URL,
    BLOG,
    PRODUCT;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
