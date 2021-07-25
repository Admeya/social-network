package com.highload.socialnetwork.services;

import com.highload.socialnetwork.model.external.UserExt;
import com.highload.socialnetwork.model.mapper.UserExt2UserMapper;
import com.highload.socialnetwork.model.persistense.AccessRole;
import com.highload.socialnetwork.model.persistense.User;
import com.highload.socialnetwork.services.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public User save(UserExt userForm) throws Exception {
        User user = UserExt2UserMapper.map(userForm);
        List<AccessRole> roles = new ArrayList<>();
        roles.add(AccessRole.USER);
        user = user.toBuilder()
                .password(encoder.encode(user.getPassword()))
                .roles(roles)
                .build();
        User findedUser = userRepository.findByLogin(userForm.getLogin());
        if (findedUser == null) {
            findedUser = userRepository.save(user);
        } else {
            throw new Exception("User already exist");
        }
        return findedUser;
    }

    public User viewUser(Long id) {
        return userRepository.findById(id);
    }
}
