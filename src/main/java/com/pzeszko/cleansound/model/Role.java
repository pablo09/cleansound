package com.pzeszko.cleansound.model;

import java.util.stream.Stream;

public enum Role {
    ADMIN, USER;

    public static String[] createRolesStringArray() {
        return Stream.of(Role.values()).map(r -> r.toString()).toArray(r -> new String[values().length]);
    }
}
