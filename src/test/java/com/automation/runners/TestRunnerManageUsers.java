package com.automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-reports/getUsers.json"},
        features = "src/test/resources/features/users/manage_users_information.feature",
        glue = {
                "com/automation/setup",
                "com/automation/stepdefinitions"
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class TestRunnerManageUsers {
}