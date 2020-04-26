package com.genil.learning.minisocialsvc.tms.repos;

import com.genil.learning.minisocialsvc.tms.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Antony Genil Gregory on 4/26/2020 3:14 PM
 * For project : mini-social-svc
 **/
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        User user = new User();
        user.setInvoiceNumber(resultSet.getString("user_id"));
        user.setUserName(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
        return user;
    }
}
