package com.JasonAnh.LaptopLABackEnd.other_services.fcm;


import com.JasonAnh.LaptopLABackEnd.entity.Notification;

public interface FCMService {
    void initialize();

    void pushNotification(Notification notification);

    void pushNotificationForTopic(Notification notification);

    void pushNotificationMultiDevice(Notification notification);

    void pushNotificationAllDevice(Notification notification);
}
