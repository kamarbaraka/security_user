package com.example.security_user.app.user.entity;

import org.springframework.security.core.GrantedAuthority;

public enum AppUserAuthorities implements GrantedAuthority {

    ADMIN("ADMIN"),
    USER("HELLO"),
    AGENT("AGENT");

    private final String authority;

    AppUserAuthorities(final String authority){
        this.authority = authority;
    }
    @Override
    public String getAuthority() {
        return this.authority;
    }
}
