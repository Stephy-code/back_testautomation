package com.automation.utils.constant.config;


import lombok.Getter;
import net.thucydides.model.util.EnvironmentVariables;

@Getter
public class Environment {

    private String baseUrl;

    public Environment(EnvironmentVariables environmentVariables) {
        initializeEnvironment(environmentVariables);
    }

    private void initializeEnvironment(EnvironmentVariables environmentVariables) {
        baseUrl = environmentVariables.getProperty("api.baseUrl");
        Logger.info(this.getClass().getName(), "base url" + ": " + baseUrl);
    }

}
