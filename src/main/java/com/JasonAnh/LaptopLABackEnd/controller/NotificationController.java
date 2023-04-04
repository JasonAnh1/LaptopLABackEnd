package com.JasonAnh.LaptopLABackEnd.controller;

import com.JasonAnh.LaptopLABackEnd.configuration.Translator;
import com.JasonAnh.LaptopLABackEnd.entity.MobileDevice;
import com.JasonAnh.LaptopLABackEnd.entity.Notification;
import com.JasonAnh.LaptopLABackEnd.entity.response.BaseResponse;
import com.JasonAnh.LaptopLABackEnd.entity.response.CountResponse;
import com.JasonAnh.LaptopLABackEnd.other_services.fcm.FCMService;
import com.JasonAnh.LaptopLABackEnd.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
@Transactional
public class NotificationController extends  BaseController{
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private FCMService fcmService;

    @GetMapping("v1/notification/get")
    public ResponseEntity<?> getNotifications(@RequestParam int page) {
        try {
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), notificationService.getNotifications(page)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage()));
        }
    }

    @PostMapping("admin/v1/notification/add")
    public ResponseEntity<?> add(@Valid @RequestBody final Notification request) {
        try {
            if (request == null
                    || request.getTitle() == null
                    || request.getContent() == null) {
                throw new Exception(Translator.toLocale("required_fields"));
            }
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), notificationService.add(request)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage()));
        }
    }

    @GetMapping("admin/v1/notification/get-notifications")
    public ResponseEntity<?> adminGetAllNotification(@RequestParam int page) {
        try {
            long totalRecord = notificationService.countNotiForAdmin();
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), notificationService.getNotificatiosForAdmin(page), totalRecord));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage()));
        }
    }

    @PostMapping("v1/device/add")
    public ResponseEntity<?> addDevice(@Valid @RequestBody final MobileDevice request) {
        try {
            if (request == null|| request.getFirebaseToken() == null || request.getAppVersion() == null || request.getOsType() == null) {
                throw new Exception(Translator.toLocale("required_fields"));
            }
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), notificationService.addDevice(request)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage()));
        }
    }
    @GetMapping("v1/device/all")
    public ResponseEntity<?> getDevice() {
        try {
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), notificationService.getAllDV()));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage()));
        }
    }
    @PostMapping("v1/notification/fcm-push")
    public ResponseEntity<?> pushNotification(@Valid @RequestBody final Notification request) {
        try {
            if (request == null || request.getTitle() == null || request.getContent() == null) {
                throw new Exception(Translator.toLocale("required_fields"));
            }
            fcmService.pushNotification(request);
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss")));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage()));
        }
    }

    @PostMapping("v1/notification/read")
    public ResponseEntity<?> read(@RequestBody final Notification notification) {
        try {
            notificationService.read(notification.getId());
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss")));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage()));
        }
    }

    @GetMapping("v1/notification/get-count-unseen")
    public ResponseEntity<?> countUnseen() {
        try {
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), new CountResponse(notificationService.countUnseen())));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage()));
        }
    }

    @PostMapping("v1/notification/read-all")
    public ResponseEntity<?> readAll() {
        try {
            notificationService.readAllNotiUnRead();
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss")));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage()));
        }
    }
}
