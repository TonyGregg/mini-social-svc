package com.genil.learning.minisocialsvc.repos;

import com.genil.learning.minisocialsvc.data.Car;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Antony Genil on 12/19/19 at 14 26 for mini-social-svc
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CarRepoTest {
    @Autowired
    CarRepo carRepo;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findAll() {
        List<Car> cars = carRepo.findAll();
        for (Car car : cars) {
            log.info("Car {} ", car);
        }
        assertTrue(cars.size() > 0);
    }

    @Test
    public void findByName() {
    }

    @Test
    public void findByCarType() {
    }
}