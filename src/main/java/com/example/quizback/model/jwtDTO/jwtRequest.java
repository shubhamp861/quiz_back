package com.example.quizback.model.jwtDTO;

public class jwtRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public jwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public jwtRequest() {
    }
}
