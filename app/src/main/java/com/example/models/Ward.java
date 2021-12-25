package com.example.models;

public class Ward {
    private String id;
    private String name;
    private String type;
    private String district_id;

    public Ward(String id, String name, String type, String district_id) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.district_id = district_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }
}
