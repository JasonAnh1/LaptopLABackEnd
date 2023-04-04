package com.JasonAnh.LaptopLABackEnd.entity;

import com.JasonAnh.LaptopLABackEnd.entity.constants.NotificationObjectType;
import com.JasonAnh.LaptopLABackEnd.entity.constants.NotificationReceiverType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "notifications")
public class Notification extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    private long ownerId;

    private Long receiverId;

    private NotificationReceiverType receiverType;

    private NotificationObjectType objectType;



    private Long objectId;



    private boolean seen;

    @Transient
    private String imageUrl;

    @Transient
    private int numUnRead;

    @Transient
    private String fcmToken;

    @Transient
    @JsonIgnore
    private List<String> fcmTokens;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ownerId", referencedColumnName = "id", insertable = false, updatable = false)
    private User owner;

    @Transient
    @JsonIgnore
    private boolean isShowAlert = true;
    @Transient
    @JsonIgnore
    private boolean forIOS = false;

    public Notification() {
    }

    public Notification(long id,
                        String title,
                        String content,
                        Long ownerId,
                        Long receiverId,
                        NotificationReceiverType receiverType,
                        NotificationObjectType objectType,
                        Long objectId,


                        boolean seen,
                        String imageUrl,
                        int numUnRead,
                        String fcmToken,
                        List<String> fcmTokens,
                        User owner,
                        boolean forIOS) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.ownerId = ownerId;
        this.receiverId = receiverId;
        this.receiverType = receiverType;
        this.objectType = objectType;
        this.objectId = objectId;


        this.seen = seen;
        this.imageUrl = imageUrl;
        this.numUnRead = numUnRead;
        this.fcmToken = fcmToken;
        this.fcmTokens = fcmTokens;
        this.owner = owner;
        this.forIOS = forIOS;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public NotificationReceiverType getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(NotificationReceiverType receiverType) {
        this.receiverType = receiverType;
    }

    public NotificationObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(NotificationObjectType objectType) {
        this.objectType = objectType;
    }


    public Long getObjectId() {
        return objectId;
    }





    public boolean isForIOS() {
        return forIOS;
    }

    public void setForIOS(boolean forIOS) {
        this.forIOS = forIOS;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getNumUnRead() {
        return numUnRead;
    }

    public void setNumUnRead(int numUnRead) {
        this.numUnRead = numUnRead;
    }

    public boolean isShowAlert() {
        return isShowAlert;
    }

    public void setShowAlert(boolean showAlert) {
        isShowAlert = showAlert;
    }

    public List<String> getFcmTokens() {
        return fcmTokens;
    }

    public void setFcmTokens(List<String> fcmTokens) {
        this.fcmTokens = fcmTokens;
    }

    @JsonIgnore
    public Notification copy() {
        return new Notification(id, title, content, ownerId,  receiverId, receiverType, objectType, objectId, seen, imageUrl, numUnRead, fcmToken, fcmTokens, owner, forIOS);
    }
}