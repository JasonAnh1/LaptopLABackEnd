package com.JasonAnh.LaptopLABackEnd.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name ="suppliers")
public class Suppliers extends DateAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 500)
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    private Long mediaId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mediaId", referencedColumnName = "id", insertable = false, updatable = false)
    private UploadFile media;

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

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public UploadFile getMedia() {
        return media;
    }

    public void setMedia(UploadFile media) {
        this.media = media;
    }
}
