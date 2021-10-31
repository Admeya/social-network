package com.highload.socialnetwork.model.external;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserExt {

    /**
     * Уникальный идентификатор пользователя
     */
    private long userId;
    /**
     * Имя пользователя
     */
    private String username;
    /**
     * Фамилия пользователя
     */
    private String surname;

    /**
     * Семейное положение
     */
    private String status;

    /**
     * Логин
     */
    private String login;

    /**
     * Зашифрованный пароль
     */
    private String password;

    /**
     * Поле подтверждения пароля на форме
     */
    private String confirmPassword;

    /**
     * Пол
     */
    private String sex;

    /**
     * Город
     */
    private String city;

    /**
     * Интересы
     */
    private String interests;

    private int age;

}
