package com.JasonAnh.LaptopLABackEnd.repository;

import com.JasonAnh.LaptopLABackEnd.entity.Notification;
import com.JasonAnh.LaptopLABackEnd.entity.constants.NotificationObjectType;
import com.JasonAnh.LaptopLABackEnd.entity.constants.NotificationSubObjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface NotificationsRepository extends JpaRepository<Notification, Long>,NotificationsRepositoryCustom {
    @Modifying
    @Query(value = "Update notifications set seen = true where receiver_id = ?1 and seen = false ", nativeQuery = true)
    void readAllNotifyByUser(long receiver_id);

    @Query(value = "SELECT  count(id) FROM notifications WHERE receiver_id = ?1 and seen = false", nativeQuery = true)
    long countUnseen(long receiver_id);

    boolean existsByOwnerIdAndReceiverIdAndObjectTypeAndObjectId(long ownerId, long receiverId, NotificationObjectType type, long objectId);

}
