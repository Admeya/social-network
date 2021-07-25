package com.highload.socialnetwork.model.mapper;

import com.highload.socialnetwork.model.external.UserExt;
import com.highload.socialnetwork.model.persistense.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserExt2UserMapper {

    public User map(UserExt userExt) {
        return User.builder()
                .name(userExt.getUsername())
                .surname(userExt.getSurname())
                .birthday(userExt.getBirthday())
                .login(userExt.getLogin())
                .password(userExt.getPassword())
                .sex(userExt.getSex())
                .city(userExt.getCity())
                .interests(userExt.getInterests())
                .age(userExt.getAge())
                .build();
    }

    public UserExt map(User user) {
        return UserExt.builder()
                .username(user.getName())
                .surname(user.getSurname())
                .birthday(user.getBirthday())
                .login(user.getLogin())
                .password(user.getPassword())
                .sex(user.getSex())
                .city(user.getCity())
                .interests(user.getInterests())
                .age(user.getAge())
                .build();
    }
}
