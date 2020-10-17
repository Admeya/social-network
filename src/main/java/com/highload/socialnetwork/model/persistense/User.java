package com.highload.socialnetwork.model.persistense;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class User {

    long userId;

    String name;

    String surname;

    String status;

    LocalDate birthday;


}
