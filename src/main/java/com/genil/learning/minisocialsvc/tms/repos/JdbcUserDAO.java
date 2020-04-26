package com.genil.learning.minisocialsvc.tms.repos;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Antony Genil Gregory on 4/25/2020 6:18 PM
 * For project : mini-social-svc
 **/
@Slf4j
public class JdbcUserDAO implements UserDAO {
    @Override
    public List<String> getAllUserNames() {
        log.info("Getting user names from RDBMS.. MySql");
        return Arrays.asList("Jim","John","Jill");
    }
}
