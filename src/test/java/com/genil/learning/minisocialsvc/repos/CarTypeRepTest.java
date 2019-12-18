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
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Antony Genil on 12/18/19 at 16 39 for mini-social-svc
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CarTypeRepTest {
    @Autowired
    CarTypeRep carTypeRep;

    @Test
    void findAll() {
        List<CarType> carTypes = carTypeRep.findAll();
//        log.info("{} ",carTypes);
        log.info("# of car types "+carTypes.size());
        assertTrue(carTypes.size()>0);
    }

}