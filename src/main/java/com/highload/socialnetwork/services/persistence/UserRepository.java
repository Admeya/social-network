package com.highload.socialnetwork.services.persistence;

import com.highload.socialnetwork.model.persistense.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    User findByLogin(String login);

    void save(User user);

    int delete(String id);
}
