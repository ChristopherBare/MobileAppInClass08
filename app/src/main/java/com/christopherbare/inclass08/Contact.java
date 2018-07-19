package com.christopherbare.inclass08;

public class Contact {
    String name, email, phone, dept, id;
    int picID;

    public String key;

    public Contact() {
    }

    public Contact(String name, String email, String phone, String dept, String id, int picID) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dept = dept;
        this.picID = picID;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getPicID() {
        return picID;
    }

    public void setPicID(int picID) {
        this.picID = picID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
