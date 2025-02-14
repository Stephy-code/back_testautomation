package com.automation.interactions;

import com.automation.models.request.User;
import com.automation.utils.constant.config.EndPoints;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class CreateUser implements Performable {
    User user;

    public CreateUser(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String pathUsers = EndPoints.USERS.get();
        actor.attemptsTo(
                Post.to(pathUsers)
                        .with(
                                request -> request
                                        .body(user)
                        )
        );
    }

    public static Performable withData(User user) {
        return Tasks.instrumented(CreateUser.class, user);
    }
}

