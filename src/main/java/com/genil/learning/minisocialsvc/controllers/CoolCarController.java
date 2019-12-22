package com.genil.learning.minisocialsvc.controllers;

import com.genil.learning.minisocialsvc.data.Car;
import com.genil.learning.minisocialsvc.repos.CarRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Antony Genil on 12/19/19 at 19 17 for mini-social-svc
 **/
@Slf4j
@RestController
@RequestMapping("/api/v1/cars-social")
public class CoolCarController {
    @Autowired
    private CarRepo carRepo;

    @GetMapping("/getAllCars")
    public List<Car> getAllCars() {
        log.info("Inside getAllCars method ");
        List<Car> cars = carRepo.findAll(Sort.by(Sort.Direction.ASC,"name"));
        log.info("# of cars returned "+cars.size());
        return cars;
    }

}
