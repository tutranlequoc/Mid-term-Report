package com.example.models;

public class Document {
    private String code;
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String identity;
    private String insurance;
    private String ethnic;
    private String job;
    private String phoneNumber_booking;
    private String email;
    private String country;
    private String city;
    private String district;
    private String ward;
    private String address;

    public Document() {

    }

    public Document(String code, String fullName, String dateOfBirth, String gender, String identity, String insurance, String ethnic, String job, String phoneNumber_booking, String email, String country, String city, String district, String ward, String address) {
        this.code = code;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.identity = identity;
        this.insurance = insurance;
        this.ethnic = ethnic;
        this.job = job;
        this.phoneNumber_booking = phoneNumber_booking;
        this.email = email;
        this.country = country;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhoneNumber_booking() {
        return phoneNumber_booking;
    }

    public void setPhoneNumber_booking(String phoneNumber_booking) {
        this.phoneNumber_booking = phoneNumber_booking;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
