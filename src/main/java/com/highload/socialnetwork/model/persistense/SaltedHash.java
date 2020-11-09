package com.highload.socialnetwork.model.persistense;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaltedHash {
    public final String salt;
    public final String hash;
}
