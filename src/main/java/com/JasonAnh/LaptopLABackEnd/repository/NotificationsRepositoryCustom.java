package com.JasonAnh.LaptopLABackEnd.repository;



import com.JasonAnh.LaptopLABackEnd.entity.Notification;
import com.JasonAnh.LaptopLABackEnd.entity.User;


import java.util.List;

interface NotificationsRepositoryCustom {
    List<Notification> getNotifications(User user, int page);

    List<Notification> getNotificationsForAdmin(int page );

    long countNotiForAdmin();


}
