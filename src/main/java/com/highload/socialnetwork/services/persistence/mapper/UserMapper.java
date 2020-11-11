package com.highload.socialnetwork.services.persistence.mapper;

import com.highload.socialnetwork.model.persistense.User;
import lombok.experimental.UtilityClass;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public class UserMapper {

    public RowMapper<User> ROW_MAPPER = (ResultSet resultSet, int rowNum) ->
            new User(
                    resultSet.getLong("user_id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getString("status"),
                    getDate(resultSet.getDate("birthday")),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    getAuthorities(resultSet.getString("roles"))
    );

    private LocalDate getDate(java.sql.Date date) {
        if (date == null) {
            return null;
        }
        return date.toLocalDate();
    }

    private static List<GrantedAuthority> getAuthorities(String strRoles) {
        List<String> roles = Arrays.asList(strRoles.split("\\s*,\\s*"));
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
