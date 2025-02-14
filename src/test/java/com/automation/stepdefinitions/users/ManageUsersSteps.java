package com.automation.stepdefinitions.users;

import com.automation.exceptions.IncorrectExpectedResponseCode;
import com.automation.exceptions.SchemaInvalid;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;

import static com.automation.tasks.CreateNewUser.createNewUser;
import static com.automation.tasks.GetUsersDetails.getUsersDetails;
import static com.automation.utils.constant.config.MessagesForFailures.*;
import static com.automation.utils.constant.config.Schemas.CREATE_USER;
import static com.automation.utils.constant.config.Schemas.GET_USERS;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ManageUsersSteps {

    @When("platform administrator tries to get the users information")
    public void platformAdministratorTriesToGetTheUsersInformation() {
        theActorInTheSpotlight().attemptsTo(getUsersDetails());
    }

    @Then("the platform administrator should see all data for users")
    public void thePlatformAdministratorShouldSeeAllDataForUsers() {
        theActorInTheSpotlight().should(
                seeThatResponse(
                        is -> is.statusCode(HttpStatus.SC_OK)
                ).orComplainWith(
                        IncorrectExpectedResponseCode.class,
                        MESSAGE_WRONG_RESPONSE_CODE_200.getMessages()
                ),
                seeThatResponse(
                        is -> is.body(JsonSchemaValidator.matchesJsonSchemaInClasspath(GET_USERS.getPath()))
                ).orComplainWith(
                        SchemaInvalid.class, MESSAGE_SCHEMA_INVALID.getMessages()
                )
        );
    }

    @When("platform administrator tries to create new user")
    public void platformAdministratorTriesToCreateNewUser() {
        theActorInTheSpotlight().attemptsTo(createNewUser());
    }
    @Then("the platform administrator should see that the user has been created")
    public void thePlatformAdministratorShouldSeeThatTheUserHasBeenCreated() {
        theActorInTheSpotlight().should(
                seeThatResponse(
                        is -> is.statusCode(HttpStatus.SC_CREATED)
                ).orComplainWith(
                        IncorrectExpectedResponseCode.class,
                        MESSAGE_WRONG_RESPONSE_CODE_202.getMessages()
                ),
                seeThatResponse(
                        is -> is.body(JsonSchemaValidator.matchesJsonSchemaInClasspath(CREATE_USER.getPath()))
                ).orComplainWith(
                        SchemaInvalid.class, MESSAGE_SCHEMA_INVALID.getMessages()
                )
        );
    }
}
