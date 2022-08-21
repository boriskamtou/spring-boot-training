package com.example.springbootwebsocket.models;

public class UserResponse {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserResponse(String content) {
        this.content = content;
    }

    public UserResponse() {
    }
}
