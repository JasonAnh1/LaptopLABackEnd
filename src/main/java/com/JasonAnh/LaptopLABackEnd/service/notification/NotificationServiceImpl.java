package com.JasonAnh.LaptopLABackEnd.service.notification;

import com.JasonAnh.LaptopLABackEnd.configuration.Translator;
import com.JasonAnh.LaptopLABackEnd.entity.MobileDevice;
import com.JasonAnh.LaptopLABackEnd.entity.Notification;
import com.JasonAnh.LaptopLABackEnd.entity.User;
import com.JasonAnh.LaptopLABackEnd.entity.constants.MobileDeviceStatus;
import com.JasonAnh.LaptopLABackEnd.entity.constants.NotificationObjectType;
import com.JasonAnh.LaptopLABackEnd.entity.constants.NotificationReceiverType;
import com.JasonAnh.LaptopLABackEnd.entity.constants.RoleName;
import com.JasonAnh.LaptopLABackEnd.entity.response.ContactResponse;
import com.JasonAnh.LaptopLABackEnd.repository.MobileDeviceRepository;
import com.JasonAnh.LaptopLABackEnd.repository.NotificationsRepository;
import com.JasonAnh.LaptopLABackEnd.service.BaseService;
import com.querydsl.core.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
class NotificationServiceImpl extends BaseService implements NotificationService {

    @Autowired
    private MobileDeviceRepository mobileDeviceRepository;

    @Autowired
    private NotificationsRepository notificationsRepository;

    @Autowired
    private com.JasonAnh.LaptopLABackEnd.other_services.fcm.FCMService FCMService;

    @Override
    public List<Notification> getNotifications(int page) throws Exception {
        User user = getUser();

        return notificationsRepository.getNotifications(user, page);
    }

    @Override
    public Notification add(Notification notification) throws Exception {
        User user = getUser();
        if (user.getRoles().get(0).getName() == RoleName.ROLE_USER) {
            throw new Exception(Translator.toLocale("access_denied"));
        }
        notification.setOwnerId(user.getId());
        notification.setOwner(user);
        if (notification.getObjectType() == null) {
            notification.setObjectType(NotificationObjectType.normal);
        }
        if(notification.getReceiverType() == null){
            notification.setReceiverType(NotificationReceiverType.ALL_USER);
        }
        notification = notificationsRepository.save(notification);
        FCMService.pushNotificationForTopic(notification);
        return notification;
    }

    @Override
    public List<Notification> getNotificatiosForAdmin(int page) throws Exception {
        return notificationsRepository.getNotificationsForAdmin(page);
    }

    @Override
    public long countNotiForAdmin() {
        return notificationsRepository.countNotiForAdmin();
    }

    @Override
    public MobileDevice addDevice(MobileDevice request) throws Exception {
        User user = getUser();
        MobileDevice mobileDevice = mobileDeviceRepository.findFirstByDeviceKey(request.getDeviceKey());
        if (mobileDevice == null || !mobileDevice.getFirebaseToken().equals(request.getFirebaseToken())) {
            if (mobileDevice == null) {
                mobileDeviceRepository.deleteByFirebaseToken(request.getFirebaseToken());
                request.setOwnerId(user.getId());
                request.setStatus(MobileDeviceStatus.on);
                return mobileDeviceRepository.save(request);
            } else {
                mobileDevice.setFirebaseToken(request.getFirebaseToken());
                mobileDevice.setOwnerId(user.getId());
                mobileDevice.setStatus(MobileDeviceStatus.on);
                return mobileDeviceRepository.save(mobileDevice);
            }
        }
        return request;
    }

    @Override
    public void deleteDevice(MobileDevice request) throws Exception {
        User user = getUser();
        mobileDeviceRepository.deleteByDeviceKey(request.getDeviceKey());

    }

    @Override
    public List<MobileDevice> getAllDV() throws Exception {
        return mobileDeviceRepository.getAllContact();
    }

    @Override
    public void read(long id) throws Exception {
        User user = getUser();
        Notification notification = notificationsRepository.findById(id).orElseThrow(() -> new Exception("Không tìm thấy dữ liệu"));
        notification.setSeen(true);
        notificationsRepository.save(notification);
    }

    @Override
    public long countUnseen() throws Exception {
        User user = getUser();
        return notificationsRepository.countUnseen(user.getId());
    }

    @Override
    public void readAllNotiUnRead() throws Exception {
        User user = getUser();
        notificationsRepository.readAllNotifyByUser(user.getId());
    }
}