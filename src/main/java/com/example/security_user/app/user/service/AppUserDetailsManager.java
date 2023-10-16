package com.example.security_user.app.user.service;

import com.example.security_user.app.user.entity.AppUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

@RequiredArgsConstructor
public class AppUserDetailsManager implements UserDetailsManager {

    private final AppUserService appUserService;
    private final ModelMapper appMapper;

    @Override
    public void createUser(UserDetails user) {

        AppUser appUser = appMapper.map(user, AppUser.class);

        appUserService.createUser(appUser);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {

        return appUserService.checkIfExists(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserService.getUserByUsername(username);
        return appMapper.map(appUser, AppUserDetails.class);
    }
}
