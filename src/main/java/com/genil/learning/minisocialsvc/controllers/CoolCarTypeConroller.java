package com.genil.learning.minisocialsvc.controllers;

import com.genil.learning.minisocialsvc.data.CarType;
import com.genil.learning.minisocialsvc.repos.CarTypeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Antony Genil Gregory on 12/22/2019 12:01 PM
 * For project : mini-social-svc
 **/

@Slf4j
@RestController
@RequestMapping("/api/v1/car-types")
public class CoolCarTypeConroller {
    @Autowired
    CarTypeRepo carTypeRepo;

    @GetMapping("/getAllCarTypes")
    public List<CarType> getAllCarTypes() {
        List<CarType> carTypes = null;
        log.info("Inside getAllCarTypes method");
        carTypes = carTypeRepo.findAll();
        log.info("Total # of car types "+ carTypes.size());
        return carTypes;
    }
}
