package com.highload.socialnetwork.model.persistense;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
public class User {

    /**
     * Уникальный идентификатор пользователя
     */
    private long userId;
    /**
     * Имя пользователя
     */
    private String name;
    /**
     * Фамилия пользователя
     */
    private String surname;

    /**
     * Семейное положение
     */
    private String status;

    /**
     * Дата рождения
     */
    private LocalDate birthday;

    /**
     * Логин
     */
    private String login;

    /**
     * Зашифрованный пароль
     */
    private String password;

    /**
     * Список ролей пользователя
     */
    private List<AccessRole> roles;

    /**
     * Пол
     */
    private String sex;

    /**
     * Город
     */
    private String city;

    private String interests;

    private int age;

}
