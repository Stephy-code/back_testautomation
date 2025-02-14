package com.automation.setup;


import com.automation.utils.constant.config.Environment;
import io.cucumber.java.Before;
import lombok.Getter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.util.EnvironmentVariables;

import static com.automation.utils.constant.config.Actors.ACTOR_JAMES;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

@Getter
public class Hooks {

    private EnvironmentVariables environmentVariables;


    @Before
    public void prepareStage() {

        OnStage.setTheStage(new OnlineCast());
        theActorCalled(ACTOR_JAMES)
                .describedAs("Actor")
                .whoCan(CallAnApi.at(new Environment(getEnvironmentVariables()).getBaseUrl()));
    }

}
