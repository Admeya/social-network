package com.highload.socialnetwork.model.persistense;

public enum AccessRole {
    ADMIN,
    USER;

    public static AccessRole from(String str) {
        for (AccessRole value : values()) {
            if (value.name().equalsIgnoreCase(str)) {
                return value;
            }
        }

        return null;
    }
}
