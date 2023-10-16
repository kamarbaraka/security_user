package com.example.security_user;

import com.example.security_user.app.user.service.AppUserDetailsManager;
import com.example.security_user.app.user.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SpringBootApplication
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityUserApplication {


    public static void main(String[] args) {
        SpringApplication.run(SecurityUserApplication.class, args);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security)throws Exception{

        security.httpBasic(customize ->
                customize.disable());

        security.authorizeHttpRequests(customize ->
                customize.requestMatchers(AntPathRequestMatcher.antMatcher("/api/v1/test/**")).authenticated().anyRequest().permitAll());

        return security.build();
    }


    /*@Bean
    public ApplicationRunner applicationRunner(UserDetailsService service){

        Runnable run = () -> {
            service.loadUserByUsername("kamarbaraka");
        };
    }*/
    @Bean
    public UserDetailsService userDetailsService(AppUserService appUserService, ModelMapper appMapper){

        return new AppUserDetailsManager(appUserService, appMapper);

    }


    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();
    }

    /*@Bean
    public AppUserService appUserService(AppUserRepository appUserRepository){

        return new AppUserService(appUserRepository);
    }*/

}
