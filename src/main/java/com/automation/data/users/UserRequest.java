package com.automation.data.users;

import com.automation.models.request.User;
import com.github.javafaker.Faker;

public class UserRequest {

    private UserRequest() {
    }

    public static User getNewuser() {
        Faker faker = new Faker();
        return User.builder()
                .name(faker.name().fullName())
                .job(faker.job().position())
                .build();
    }
}
