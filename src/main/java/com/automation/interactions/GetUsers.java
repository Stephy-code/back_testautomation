package com.automation.interactions;

import com.automation.utils.constant.config.EndPoints;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetUsers implements Performable {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String pathUsers = EndPoints.USERS.get();
        actor.attemptsTo(
                Get.resource(pathUsers)
        );
    }

    public static Performable information() {
        return Tasks.instrumented(GetUsers.class);
    }
}

