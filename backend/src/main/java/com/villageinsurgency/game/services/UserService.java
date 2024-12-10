package com.villageinsurgency.game.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    // TODO: Handle uniqueness issue
    public boolean createUser(String username, String email) {
        String sql = "INSERT INTO Users (username, email) VALUES (?, ?)";
        int rowsAffected = 0;
        rowsAffected = jdbcTemplate.update(sql, username, email);
        System.out.println(rowsAffected);
        return  rowsAffected > 0;
    }

//    public boolean getUser(String username) {
//        String sql = "SELECT * FROM Users WHERE username = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{username}, (rs, rowNum) -> rs.getString("username")) != null;
//    }
}
