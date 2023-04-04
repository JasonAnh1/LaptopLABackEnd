package com.JasonAnh.LaptopLABackEnd.repository;

import com.JasonAnh.LaptopLABackEnd.entity.Notification;
import com.JasonAnh.LaptopLABackEnd.entity.QNotification;
import com.JasonAnh.LaptopLABackEnd.entity.User;
import com.JasonAnh.LaptopLABackEnd.entity.constants.NotificationReceiverType;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.JasonAnh.LaptopLABackEnd.util.Util.PAGE_SIZE;


@Repository
class NotificationsRepositoryImpl extends BaseRepository implements NotificationsRepositoryCustom {

    @Override
    public List<Notification> getNotifications(User user, int page) {
        QNotification qNotification = QNotification.notification;

        BooleanBuilder builder = new BooleanBuilder();




        return query().from(qNotification)
                .where(builder)
                .select(qNotification)
                .offset(PAGE_SIZE * page).limit(PAGE_SIZE)
                .orderBy(qNotification.id.desc())
                .fetch();

    }

    @Override
    public List<Notification> getNotificationsForAdmin(int page) {
        QNotification qNotification = QNotification.notification;

        BooleanBuilder builder = new BooleanBuilder();

//        builder.and(qNotification.objectType.eq(NotificationObjectType.normal));
        builder.and(qNotification.receiverType.notIn(NotificationReceiverType.ONE_USER));

        return query().from(qNotification)
                .where(builder)
                .select(qNotification)
                .offset(PAGE_SIZE * page).limit(PAGE_SIZE)
                .orderBy(qNotification.id.desc())
                .fetch();
    }

    @Override
    public long countNotiForAdmin() {
        QNotification qNotification = QNotification.notification;
        BooleanBuilder builder = new BooleanBuilder();

//        builder.and(qNotification.objectType.eq(NotificationObjectType.normal));
        builder.and(qNotification.receiverType.notIn(NotificationReceiverType.ONE_USER));

        return query().from(qNotification)
                .where(builder)
                .fetchCount();
    }

}
