package com.genil.learning.minisocialsvc.utils.hal;

import com.genil.learning.minisocialsvc.tms.controllers.UserController;
import com.genil.learning.minisocialsvc.tms.model.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Created by Antony Genil Gregory on 1/5/2020 9:23 AM
 * For project : mini-social-svc
 **/
@Component
public class UserEntityAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {
    @Override
    public EntityModel<User> toModel(User user) {
        return new EntityModel<>(user, linkTo(methodOn(UserController.class).getOneUser(user.getUserId())).withSelfRel(),
                linkTo(methodOn(UserController.class).getAllUsers()).withRel("users"));
    }
}
