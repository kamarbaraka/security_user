package com.example.security_user.app.user.controller;


import com.example.security_user.app.user.entity.AppUser;
import com.example.security_user.app.user.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"api/v1/test"})
@RequiredArgsConstructor
public class TestController {

    private final AppUserService appUserService;

    @PostMapping
    @PreAuthorize(value = "permitAll()")
    public ResponseEntity<EntityModel<AppUser>> createUser(@Validated @RequestBody AppUser appUser){

        /*create a user*/
        appUserService.createUser(appUser);
        /*create a response*/
        EntityModel<AppUser> appUserEntityModel = EntityModel.of(appUser);
        appUserEntityModel.add(WebMvcLinkBuilder.linkTo(TestController.class).withSelfRel());
        /*return the response*/
        return ResponseEntity.status(201).body(appUserEntityModel);
    }
}
