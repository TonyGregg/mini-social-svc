package com.genil.learning.minisocialsvc.tms.repos;

import com.genil.learning.minisocialsvc.tms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Antony Genil on 4/26/2020 at 3:13 PM, for project - mini-social-svc.
 **/
@Repository
public class UserJdbcRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<User> findAll() {
        return jdbcTemplate.query("select * from users", new UserRowMapper());
    }

    public User findUser(String userId) {
        return jdbcTemplate.queryForObject("select * from users where user_id = ?", new Object[]{userId},
                new UserRowMapper());
    }
}
