package com.highload.socialnetwork.model.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SearchExt {

    /**
     * Имя и фамилия пользователя
     */
    private String username;
}
