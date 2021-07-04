package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String familyName;
    private String email;
    private String password;
    private String role;

    public User() {

    }

    public User(Long id,String name, String familyName, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String name, String familyName, String email, String password) {
        this.name = name;
        this.familyName = familyName;
        this.email = email;
        this.password = password;
        this.role = "STU";
    }



    public User(String name, String familyName, String email, String password, String role) {
        this.name = name;
        this.familyName = familyName;
        this.email = email;
        this.password = password;
        this.role = role;
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

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passWord) {
        this.password = passWord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
