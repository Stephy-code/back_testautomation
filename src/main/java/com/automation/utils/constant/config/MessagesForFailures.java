package com.automation.utils.constant.config;

import lombok.Getter;

@Getter
public enum MessagesForFailures {

    MESSAGE_WRONG_RESPONSE_CODE_200("200 response code was expected"),
    MESSAGE_WRONG_RESPONSE_CODE_202("202 response code was expected"),
    MESSAGE_SCHEMA_INVALID("The structure of the response body is not the expected");


    private final String messages;

    MessagesForFailures(String messages) {
        this.messages = messages;
    }

}
