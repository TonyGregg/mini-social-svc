package com.genil.learning.minisocialsvc.tms.repos;

import com.genil.learning.minisocialsvc.tms.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Antony Genil on 4/26/2020 at 3:36 PM, for project - mini-social-svc.
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserJdbcRepoTest {

    @Autowired private UserJdbcRepo userJdbcRepo;


    @Test
    public void findAll() {
        List<User> users = userJdbcRepo.findAll();
        assertNotNull(users);
        assertTrue(!users.isEmpty());
    }

    @Test
    public void findUser() {
        User user = userJdbcRepo.findUser("Roger0915");
        log.info("User "+ user);
        assertNotNull(user);

    }
}