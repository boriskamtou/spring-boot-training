package com.example.springbootwebsocket.models;

public class Message {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;

    public Message(String name) {
        this.name = name;
    }
}
