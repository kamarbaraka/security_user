package com.example.security_user.app.user.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Collection;

/**
 * the app user*/

@Entity
@Data
public class AppUser  {

    @Id
    @Column(nullable = false)
    private String username;
    private String  password;
    @Enumerated(EnumType.STRING)
    private Collection<AppUserAuthorities> authorities;
    private boolean enabled = true;
}
