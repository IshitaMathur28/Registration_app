package com.example.registration_app;

public class Users {
    String name,college,phone;
    public Users(){

    }

    public Users(String name, String college, String phone) {
        this.name = name;
        this.college = college;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}