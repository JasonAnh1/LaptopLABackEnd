package com.JasonAnh.LaptopLABackEnd.entity;

import com.JasonAnh.LaptopLABackEnd.entity.constants.MobileDeviceStatus;


import javax.persistence.*;

@Entity
@Table(name = "mobile_devices")
public class MobileDevice extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firebaseToken;



    private String deviceKey;

    private long ownerId;

    private String osType;

    private String appVersion;

    private MobileDeviceStatus status;

    @ManyToOne
    @JoinColumn(name ="ownerId", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirebaseToken() {
        return firebaseToken;
    }

    public void setFirebaseToken(String firebaseToken) {
        this.firebaseToken = firebaseToken;
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public MobileDeviceStatus getStatus() {
        return status;
    }

    public void setStatus(MobileDeviceStatus status) {
        this.status = status;
    }
}