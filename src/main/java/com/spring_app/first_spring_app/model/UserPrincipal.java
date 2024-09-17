package com.spring_app.first_spring_app.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails{

    private Users user;

    public UserPrincipal(Users user) {
        this.user = user; 
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; 
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getName();
    }

}
