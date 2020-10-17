package com.highload.socialnetwork.services.persistence.mapper;

import com.highload.socialnetwork.model.persistense.User;
import lombok.experimental.UtilityClass;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.time.LocalDate;

@UtilityClass
public class UserMapper {

    public RowMapper<User> ROW_MAPPER = (ResultSet resultSet, int rowNum) ->
            new User(
                    resultSet.getLong("user_id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getString("status"),
                    getDate(resultSet.getDate("birthday"))
    );

    private LocalDate getDate(java.sql.Date date) {
        if (date == null) {
            return null;
        }
        return date.toLocalDate();
    }
}
