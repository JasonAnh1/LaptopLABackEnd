package com.JasonAnh.LaptopLABackEnd.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name ="products_category")
public class ProductCategory extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 500)
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
