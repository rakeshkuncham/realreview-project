package com.example.realreview.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "image_metadata")
public class ImageMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uploader;      // username or userId who uploaded

    private String fileName;      // stored image file name/path

    private String location;      // location where photo was clicked

    private LocalDateTime uploadTime;  // timestamp of upload

    private double rating;        // average rating, initially 0

    public ImageMetadata() {
    }

    // Constructors, Getters and Setters

    public ImageMetadata(String uploader, String fileName, String location, LocalDateTime uploadTime) {
        this.uploader = uploader;
        this.fileName = fileName;
        this.location = location;
        this.uploadTime = uploadTime;
        this.rating = 0.0;
    }

    // getters and setters for all fields below
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUploader() { return uploader; }
    public void setUploader(String uploader) { this.uploader = uploader; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getUploadTime() { return uploadTime; }
    public void setUploadTime(LocalDateTime uploadTime) { this.uploadTime = uploadTime; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
}
