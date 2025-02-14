package com.automation.utils.constant.config;

import org.slf4j.LoggerFactory;

public final class Logger {

    private Logger() {
    }

    public static void error(String className, String message) {
        LoggerFactory.getLogger(className).error(message);
    }

    public static void info(String className, String message) {
        LoggerFactory.getLogger(className).info(message);
    }
}
