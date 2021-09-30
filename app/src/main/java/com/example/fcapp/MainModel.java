package com.example.fcapp;

public class MainModel {
    String location, date, code;

    public MainModel() {
    }

    public MainModel(String location, String date, String code) {
        this.location = location;
        this.date = date;
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
