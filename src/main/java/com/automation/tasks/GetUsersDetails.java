package com.automation.tasks;

import com.automation.interactions.GetUsers;
import lombok.Getter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.model.util.EnvironmentVariables;

@Getter
public class GetUsersDetails implements Task {

    private EnvironmentVariables environmentVariables;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetUsers.information()
        );
    }

    public static GetUsersDetails getUsersDetails() {
        return Tasks.instrumented(GetUsersDetails.class);
    }
}
