package com.genil.learning.minisocialsvc.controllers;

import com.genil.learning.minisocialsvc.data.Car;
import com.genil.learning.minisocialsvc.exception.CarNotFoundException;
import com.genil.learning.minisocialsvc.repos.CarRepo;
import com.genil.learning.minisocialsvc.utils.hal.CarEntityAssembler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Antony Genil on 12/19/19 at 19 17 for mini-social-svc
 **/
@Slf4j
@RestController
@RequestMapping("/api/v1/cars-social")
public class CoolCarController {
    @Autowired
    private CarRepo carRepo;
    @Autowired
    CarEntityAssembler carEntityAssembler;
    @Value("${server.ip}")
    String serverIp;

    @GetMapping("/cars")
//    @ApiOperation(value = "Fetch cars list", nickname = "FetchCars Quick", notes = "This endpoint will fetch all the cars" +
//            "in the order of ID ascending")
    public CollectionModel<EntityModel<Car>> getAllCars() {
        log.info("Inside getAllCars method ");
        List<Car> cars = carRepo.findAll(Sort.by(Sort.Direction.ASC,"id"));
        log.info("# of cars returned "+cars.size() +" Going to stream on cars and creating HATEOAS REST style content");
        List<EntityModel<Car>> entityModels = cars.stream().map(carEntityAssembler::toModel)
                .collect(Collectors.toList());


        return new CollectionModel<>(entityModels, WebMvcLinkBuilder.
                linkTo(WebMvcLinkBuilder.methodOn(CoolCarController.class).getAllCars()).withSelfRel());
    }

    @GetMapping("/cars/{id}")
    public  EntityModel<Car> getCar(@PathVariable(value = "id") Long id) {
        log.info("Id passed {} ", id);
        log.info(("Server IP address "+serverIp));
        Car car = carRepo.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
//        return new EntityModel<>(car,
//                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
//                        .methodOn(CoolCarController.class).getCar(id)).withSelfRel(),
//                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CoolCarController.class).
//                        getAllCars()).withRel("cars"));

        return carEntityAssembler.toModel(car);



    }

    /**
     * POST is for create new
     * @param car
     * @return
     */
    @PostMapping("/cars")
    @ResponseStatus(HttpStatus.CREATED)
    EntityModel<Car> newCar(@Valid @RequestBody Car car) {
        EntityModel<Car> carEntityModel = carEntityAssembler.toModel(carRepo.save(car));
        return carEntityModel;
    }

    /**
     * PUT - UPDATE !!!
     * @param newCar
     * @param id
     * @return
     */
    @PutMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Car replaceCar(@RequestBody Car newCar, @PathVariable Long id) {
        log.info("Id passed in put "+id);
        return carRepo.findById(id)
                .map(car -> {
                    log.info("Updating existing  car record "+id);
                    car.setCarType(newCar.getCarType());
                    car.setName(newCar.getName());
                    return carRepo.save(car);
                }).orElseGet(() -> {
                    log.info("Creating new car "+id);
                   newCar.setId(id);
                   return carRepo.save(newCar);
                });
    }

    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable Long id) {
        carRepo.deleteById(id);
    }


}
