package com.JasonAnh.LaptopLABackEnd.service.notification;


import com.JasonAnh.LaptopLABackEnd.entity.MobileDevice;
import com.JasonAnh.LaptopLABackEnd.entity.Notification;
import com.JasonAnh.LaptopLABackEnd.entity.response.ContactResponse;
import com.querydsl.core.Tuple;

import java.util.List;

public interface NotificationService {
    List<Notification> getNotifications(int page) throws Exception;
    Notification add(Notification notification) throws Exception;
    List<Notification> getNotificatiosForAdmin(int page) throws Exception;
    long countNotiForAdmin();
    MobileDevice addDevice(MobileDevice request) throws Exception;
    void deleteDevice(MobileDevice request) throws Exception;
    List<MobileDevice> getAllDV() throws Exception;
    void read(long id) throws Exception;
    long countUnseen() throws Exception;
    void readAllNotiUnRead() throws Exception;
}