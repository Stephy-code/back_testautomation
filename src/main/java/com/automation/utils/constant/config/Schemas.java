package com.automation.utils.constant.config;

import lombok.Getter;

@Getter
public enum Schemas {

    GET_USERS("schemas/users/successGetUsersResponse.json"),
    CREATE_USER("schemas/users/successCreateNewUsersResponse.json");

    private final String path;

    Schemas(String path) {
        this.path = path;
    }

}
