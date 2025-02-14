package com.automation.utils.constant.config;

public enum EndPoints {
    USERS("/api/users");

    private final String path;

    EndPoints(String path) {
        this.path = path;
    }

    public String get() {
        return path;
    }

}
