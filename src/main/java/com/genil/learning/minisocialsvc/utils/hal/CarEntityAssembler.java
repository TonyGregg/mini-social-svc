package com.genil.learning.minisocialsvc.utils.hal;

import com.genil.learning.minisocialsvc.controllers.CoolCarController;
import com.genil.learning.minisocialsvc.data.Car;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

/**
 * Created by Antony Genil Gregory on 1/5/2020 9:23 AM
 * For project : mini-social-svc
 **/
@Component
public class CarEntityAssembler implements RepresentationModelAssembler<Car, EntityModel<Car>> {
    @Override
    public EntityModel<Car> toModel(Car car) {
        return new EntityModel<>(car, linkTo(methodOn(CoolCarController.class).getCar(car.getId())).withSelfRel(),
                linkTo(methodOn(CoolCarController.class).getAllCars()).withRel("cars"));
    }
}
