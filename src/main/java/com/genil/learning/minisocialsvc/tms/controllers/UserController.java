package com.genil.learning.minisocialsvc.tms.controllers;

import com.genil.learning.minisocialsvc.tms.model.User;
import com.genil.learning.minisocialsvc.tms.service.UserService;
import com.genil.learning.minisocialsvc.utils.hal.UserEntityAssembler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Antony Genil Gregory on 1/7/2020 4:10 PM
 * For project : mini-social-svc
 **/
@RestController
@RequestMapping("/api/v1/user-svc")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserEntityAssembler userEntityAssembler;

    @GetMapping("/users")
    public CollectionModel<EntityModel<User>> getAllUsers() {
        log.info("Get users method");
        List<User> users =  userService.getAllUsers();
        log.info("# of users "+users.size());
        List<EntityModel<User>> entityModels = users
                .stream()
                .map(userEntityAssembler::toModel)
                .collect(Collectors.toList());
        return new CollectionModel<>(entityModels,WebMvcLinkBuilder
                        .linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getAllUsers()).withSelfRel());

    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getOneUser(@PathVariable("id") Integer userId) {
        log.info("Getting one User. User ID passed "+userId);
        return userEntityAssembler.toModel(userService.getUser(userId));
    }

    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User user) {
        log.info("Creating new user "+user);
        return userService.addUser(user);
    }

    @PutMapping("/users")
    public User updateUser(@Valid @RequestBody User user) {
        log.info("Updating the user");
        userService.updateUser(user);
        return user;
    }

    @DeleteMapping("/users")
    public User deleteUser(@Valid @RequestBody User user) {
        log.info("Removing user "+user);
        userService.deleteUser(user);
        return user;
    }
}
