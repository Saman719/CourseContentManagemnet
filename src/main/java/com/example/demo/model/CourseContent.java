package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
public class CourseContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
//    @Temporal(TemporalType.DATE)
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private Date expirationDate;
    private String url;
    int guestVisible;

    public CourseContent() {

    }

    public CourseContent(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public CourseContent(String name, String description, String url , int guestVisible) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.guestVisible = guestVisible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getGuestVisible() {
        return guestVisible;
    }

    public void setGuestVisible(int guestVisible) {
        this.guestVisible = guestVisible;
    }
}
