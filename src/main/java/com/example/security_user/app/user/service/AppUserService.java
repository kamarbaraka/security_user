package com.example.security_user.app.user.service;


import com.example.security_user.app.user.entity.AppUser;
import com.example.security_user.app.user.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public void createUser(AppUser user){

        /*create a user*/
        appUserRepository.save(user);
    }

    public boolean checkIfExists(String username){

        return appUserRepository.findById(username).isPresent();
    }

    public AppUser getUserByUsername(String username) throws UsernameNotFoundException{

        /*find the user*/
        return appUserRepository.findById(username).orElseThrow(
                () -> new UsernameNotFoundException("nu such user")
        );

    }
}
