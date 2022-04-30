package com.example.quizback.model.jwtDTO;

import org.springframework.security.core.GrantedAuthority;

public class AuthorityForUser implements GrantedAuthority {
    private String role;
    @Override
    public String getAuthority() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public AuthorityForUser(String role) {
        this.role = role;
    }
}
