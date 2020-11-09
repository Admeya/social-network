package com.highload.socialnetwork.model.persistense;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
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
     * Соль пароля
     */
    private String passwordSalt;

    /**
     * Хэш пароля
     */
    private String passwordHash;



}
