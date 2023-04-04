package com.JasonAnh.LaptopLABackEnd.entity;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location extends DateAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
