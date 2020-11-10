package com.highload.socialnetwork.services.persistence.impl;

import com.highload.socialnetwork.model.persistense.User;
import com.highload.socialnetwork.services.persistence.UserRepository;
import com.highload.socialnetwork.services.persistence.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByLogin(String login) {
        String preparedByLogin = "select * from db_social.users where login = ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(preparedByLogin, new Object[]{login}, UserMapper.ROW_MAPPER);
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find entity of type Person with login {}", login);
        }
        return user;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public int delete(String id) {
        return 0;
    }
}
