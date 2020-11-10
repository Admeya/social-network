package com.highload.socialnetwork.model.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
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
     * Поле подтверждения пароля на форме
     */
    private String confirmPassword;

}
