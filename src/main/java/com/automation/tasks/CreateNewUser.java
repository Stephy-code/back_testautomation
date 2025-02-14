package com.automation.tasks;

import com.automation.data.users.UserRequest;
import com.automation.interactions.CreateUser;
import lombok.Getter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.model.util.EnvironmentVariables;

@Getter
public class CreateNewUser implements Task {

    private EnvironmentVariables environmentVariables;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CreateUser.withData(UserRequest.getNewuser())
        );
    }

    public static CreateNewUser createNewUser() {
        return Tasks.instrumented(CreateNewUser.class);
    }
}
