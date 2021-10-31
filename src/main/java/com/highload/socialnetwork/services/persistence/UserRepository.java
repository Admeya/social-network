package com.highload.socialnetwork.services.persistence;

import com.highload.socialnetwork.model.persistense.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    User findByLogin(String login);

    User findById(Long login);

    User save(User user);

    int delete(String id);

    List<User> findByNameSurname(String name, String surname);
}
