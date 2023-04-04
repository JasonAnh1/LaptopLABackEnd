package com.JasonAnh.LaptopLABackEnd.entity.response;

public class ContactResponse {
    String userName;
    String fcmToken;

    public ContactResponse(){

    };
    public ContactResponse(String userName, String fcmToken) {
        this.userName = userName;
        this.fcmToken = fcmToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }
}
