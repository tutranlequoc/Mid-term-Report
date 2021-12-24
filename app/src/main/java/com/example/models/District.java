package com.example.models;

public class District {
    private String id;
    private String name;
    private String type;
    private String province_id;

    public District(String id, String name, String type, String province_id) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.province_id = province_id;
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

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }
}
