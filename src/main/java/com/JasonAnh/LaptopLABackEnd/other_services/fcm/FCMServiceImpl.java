package com.JasonAnh.LaptopLABackEnd.other_services.fcm;

import com.JasonAnh.LaptopLABackEnd.entity.constants.NotificationReceiverType;
import com.JasonAnh.LaptopLABackEnd.service.BaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
class FCMServiceImpl extends BaseService implements FCMService {
    @Value("${app.firebase-configuration-file}")
    private String firebaseConfigPath;

    @Value("${app.firebase.topic.all}")
    private String TOPIC_ALL;

    @Value("${app.firebase.topic.user}")
    private String TOPIC_ALL_USER;

    @Value("${app.firebase.topic.all_level}")
    private String TOPIC_ALL_LEVEL;




    @PostConstruct
    public void initialize() {
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource(firebaseConfigPath).getInputStream()))
                    .build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pushNotification(com.JasonAnh.LaptopLABackEnd.entity.Notification notification) {
        if (notification != null) {
//            Thread thread = new Thread(() -> {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
            String notificationString = null;
            try {
                notificationString = mapper.writeValueAsString(notification);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            if (notificationString != null) {
                Message.Builder messageBuilder = Message.builder()
                        .putData("result", notificationString)
                        .putData("title", notification.getTitle())
                        .putData("content", notification.getContent())
                        .setAndroidConfig(getAndroidConfig())
                        .setApnsConfig(getApnsConfig());
                if (notification.isShowAlert()) {
                    messageBuilder.setNotification(Notification.builder().setTitle(notification.getTitle())
                            .setBody(notification.getContent())
                            .setImage(notification.getImageUrl()).build());
                }
                if (notification.getReceiverType() == NotificationReceiverType.ONE_USER) {
                    if (notification.getFcmToken() != null) {
                        String token = notification.getFcmToken();
                        messageBuilder.setToken(token);
                    }
                } else {
                    messageBuilder.setTopic(TOPIC_ALL);
                }
                Message message = messageBuilder.build();
                FirebaseMessaging.getInstance().sendAsync(message);
            }
//            });
//            thread.start();
        }
    }

    @Override
    public void pushNotificationForTopic(com.JasonAnh.LaptopLABackEnd.entity.Notification notification) {
        if (notification != null) {
//            Thread thread = new Thread(() -> {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
            String notificationString = null;
            try {
                notificationString = mapper.writeValueAsString(notification);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            if (notificationString != null) {
                Message.Builder messageBuilder = Message.builder()
                        .putData("result", notificationString)
                        .putData("title", notification.getTitle())
                        .putData("content", notification.getContent())
                        .setAndroidConfig(getAndroidConfig())
                        .setApnsConfig(getApnsConfig());
                if (notification.isShowAlert()) {
                    messageBuilder.setNotification(Notification.builder().setTitle(notification.getTitle())
                            .setBody(notification.getContent())
                            .setImage(notification.getImageUrl()).build());
                }
//                if (notification.getReceiverType() == NotificationReceiverType.ONE_USER) {
//                    if (notification.getFcmToken() != null) {
//                        String token = notification.getFcmToken();
//                        messageBuilder.setToken(token);
//                    }
//                } else {

                    messageBuilder.setTopic(TOPIC_ALL);

                Message message = messageBuilder.build();
                FirebaseMessaging.getInstance().sendAsync(message);
                messageBuilder.setNotification(Notification.builder()
                        .setTitle(notification.getTitle())
                        .setBody(notification.getContent())
                        .setImage(notification.getImageUrl())
                        .build());



                FirebaseMessaging.getInstance().sendAsync(messageBuilder.build());

//                }


            }
//            });
//            thread.start();
        }
    }

    public void pushNotificationMultiDevice(com.JasonAnh.LaptopLABackEnd.entity.Notification notification) {
        if (notification != null) {
//            Thread thread = new Thread(() -> {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
            String notificationString = null;
            try {
                notificationString = mapper.writeValueAsString(notification);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            if (notificationString != null) {
                int MAX_TOKEN = 499;
                int ratio = notification.getFcmTokens().size() / MAX_TOKEN;
                for (int i = 0; i <= ratio; i++) {
                    int start = i * MAX_TOKEN;
                    int end = (i + 1) * MAX_TOKEN;
                    List<String> tokens = new ArrayList<>();
                    for (int j = start; j < end; j++) {
                        if (notification.getFcmTokens().size() > j) {
                            tokens.add(notification.getFcmTokens().get(j));
                        }
                    }
                    MulticastMessage.Builder messageBuilder = MulticastMessage.builder()
                            .putData("result", notificationString)
                            .putData("title", notification.getTitle())
                            .putData("content", notification.getContent())
                            .addAllTokens(tokens)
                            .setAndroidConfig(getAndroidConfig())
                            .setApnsConfig(getApnsConfig());
                    messageBuilder.setNotification(Notification.builder()
                            .setTitle(notification.getTitle())
                            .setBody(notification.getContent())
                            .setImage(notification.getImageUrl()).build());
                    FirebaseMessaging.getInstance().sendMulticastAsync(messageBuilder.build());


                }
            }
//            });
//            thread.start();
        }
    }

    @Override
    public void pushNotificationAllDevice(com.JasonAnh.LaptopLABackEnd.entity.Notification notification) {
        if (notification != null) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
            String notificationString = null;
            try {
                notificationString = mapper.writeValueAsString(notification);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            if (notificationString != null) {
                Message.Builder messageBuilder = Message.builder()
                        .putData("result", notificationString)
                        .putData("title", notification.getTitle())
                        .putData("content", notification.getContent())
                        .setAndroidConfig(getAndroidConfig())
                        .setApnsConfig(getApnsConfig());
                messageBuilder.setTopic(TOPIC_ALL);
                FirebaseMessaging.getInstance().sendAsync(messageBuilder.build());

                messageBuilder.setNotification(Notification.builder()
                        .setTitle(notification.getTitle())
                        .setBody(notification.getContent())
                        .setImage(notification.getImageUrl())
                        .build());



                FirebaseMessaging.getInstance().sendAsync(messageBuilder.build());
            }
        }
    }

    AndroidConfig getAndroidConfig() {
        return AndroidConfig.builder()
                .setPriority(AndroidConfig.Priority.HIGH)
//                .setNotification(AndroidNotification.builder()
//                        .setPriority(AndroidNotification.Priority.HIGH)
//                        .setSound("default")
//                        .setDefaultSound(true)
//                        .setDefaultVibrateTimings(true)
//                        .setDefaultLightSettings(true)
//                        .build())
                .build();
    }

    ApnsConfig getApnsConfig() {
        return ApnsConfig.builder()
                .setAps(Aps.builder().setSound("default").build())
                .build();
    }
}