package com.boris.restfull_web_service.entities;

import java.util.Date;

public class User {

    private Long id;
    private String name;
    private Date birthData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User(Long id, String name, Date birthData) {
        this.id = id;
        this.name = name;
        this.birthData = birthData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthData() {
        return birthData;
    }

    public void setBirthData(Date birthData) {
        this.birthData = birthData;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthData=" + birthData +
                '}';
    }
}
