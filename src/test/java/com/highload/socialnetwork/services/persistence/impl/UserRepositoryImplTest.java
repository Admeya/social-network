package com.highload.socialnetwork.services.persistence.impl;

import com.highload.socialnetwork.model.persistense.User;
import com.highload.socialnetwork.services.persistence.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepositoryImplTest {

    @Autowired
    private UserRepository userRepository;

    private JdbcTemplate jdbcTemplate;

    @Before
    public void init() {
        jdbcTemplate = new JdbcTemplate();
        userRepository = new UserRepositoryImpl(jdbcTemplate);
    }

    @Test
    public void findById() {

        User user = userRepository.findById(1L);

        System.out.println(user);
    }
}