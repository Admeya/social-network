package com.highload.socialnetwork.services.persistence.impl;

import com.highload.socialnetwork.model.persistense.AccessRole;
import com.highload.socialnetwork.model.persistense.User;
import com.highload.socialnetwork.services.persistence.UserRepository;
import com.highload.socialnetwork.services.persistence.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        String preparedByLogin = "select u.*, 'USER' as roles\n" +
                "from users u where login = ?";

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
        String preparedSaveUser = "INSERT INTO users(name, surname, login, password, sex, city, interests, age) VALUES(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(preparedSaveUser, user.getName(), user.getSurname(),
                user.getLogin(), user.getPassword(), user.getSex(), user.getCity(), user.getInterests(), user.getAge());

        User savedUser = findByLogin(user.getLogin());
        String preparedRoleSearch = "SELECT role_id FROM role WHERE name = ?";
        String preparedUserRoleInsert = "INSERT INTO user_role(user_id, role_id) VALUES (?,?)";
        for (AccessRole role : user.getRoles()) {
            long idRole = jdbcTemplate.queryForObject(preparedRoleSearch, new Object[]{role.name()}, Long.class);
            jdbcTemplate.update(preparedUserRoleInsert, savedUser.getUserId(), idRole);
        }
        return savedUser;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public User findById(Long id) {
        String preparedByLogin = "select u.*, (select group_concat(r.name) as roles\n" +
                "from users u\n" +
                "    left join user_role ur on u.user_id = ur.user_id\n" +
                "    left join role r on ur.role_id = r.role_id\n" +
                "where u.user_id=?) as roles\n" +
                "from users u where user_id = ?";

        User user = null;
        try {
            user = jdbcTemplate.queryForObject(preparedByLogin, new Object[]{id, id}, UserMapper.ROW_MAPPER);
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find entity of type Person with login {}", id);
        }
        return user;
    }

    @Override
    public List<User> findByNameSurname(String name, String surname) {
        String preparedByNameSurname = "select u.*, 'USER' as roles\n" +
                "from users u where name LIKE CONCAT( ?,'%') and surname LIKE CONCAT( ?,'%') order by user_id";

        List<User> users = new ArrayList<>();
        try {
            users.addAll(jdbcTemplate.query(preparedByNameSurname, new Object[]{name, surname}, UserMapper.ROW_MAPPER));
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find entity of type Person with name {} and surname {}", name, surname);
        }
        return users;
    }
}
