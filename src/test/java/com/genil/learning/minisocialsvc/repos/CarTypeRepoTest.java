package com.genil.learning.minisocialsvc.repos;

import com.genil.learning.minisocialsvc.data.CarType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Antony Genil on 12/18/19 at 16 39 for mini-social-svc
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CarTypeRepoTest {
    @Autowired
    CarTypeRepo carTypeRepo;

    @Test
    void findAll() {
        List<CarType> carTypes = carTypeRepo.findAll();
//        log.info("{} ",carTypes);
        log.info("# of car types "+carTypes.size());
        for ( CarType carType : carTypes ) {
            log.info("{} ", carType);
        }
        assertTrue(carTypes.size()>0);
    }

}