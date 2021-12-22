package com.example.models;

public class User {
    private String phone;
    private String fullName;

    public User(String phone, String fullName) {
        this.phone = phone;
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
