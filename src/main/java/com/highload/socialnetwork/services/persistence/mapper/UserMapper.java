package com.highload.socialnetwork.services.persistence.mapper;

import com.highload.socialnetwork.model.persistense.AccessRole;
import com.highload.socialnetwork.model.persistense.User;
import lombok.experimental.UtilityClass;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@UtilityClass
public class UserMapper {

    public RowMapper<User> ROW_MAPPER = (ResultSet resultSet, int rowNum) ->
            new User(
                    resultSet.getLong("user_id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    getAuthorities(resultSet.getString("roles")),
                    resultSet.getString("sex"),
                    resultSet.getString("city"),
                    resultSet.getString("interests"),
                    resultSet.getInt("age")
            );

    private LocalDate getDate(java.sql.Date date) {
        if (date == null) {
            return null;
        }
        return date.toLocalDate();
    }

    private static List<AccessRole> getAuthorities(String strRoles) {
        if (Objects.isNull(strRoles)) {
            return new ArrayList<>();
        }

        List<String> roles = Arrays.asList(strRoles.split("\\s*,\\s*"));
        List<AccessRole> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(AccessRole.from(role));
        }
        return authorities;
    }
}
