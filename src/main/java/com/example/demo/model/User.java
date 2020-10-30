package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Long userID;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String hashedPassword;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String userRank;

    @Column(nullable = false)
    private String phoneNumber;

    public User() {
        super();
    }

    public User(String fullName, String email, String hashedPassword, String department, String userRank, String phoneNumber) {
        super();
        this.fullName = fullName;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.department = department;
        this.userRank = userRank;
        this.phoneNumber = phoneNumber;
    }

    public Long getUserID() {
        return userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUserRank() {
        return userRank;
    }

    public void setUserRank(String userRank) {
        this.userRank = userRank;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}