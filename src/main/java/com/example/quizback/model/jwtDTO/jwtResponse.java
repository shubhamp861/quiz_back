package com.example.quizback.model.jwtDTO;

public class jwtResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public jwtResponse(String token) {
        this.token = token;
    }

    public jwtResponse() {
    }
}
