package com.JasonAnh.LaptopLABackEnd.entity.constants;


public enum CodePaymentVnpay {
    RECHARGE("RECHARGE"),
    ORDER_PRODUCT("ORDER_PRODUCT");

    private String value;

    private CodePaymentVnpay(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
