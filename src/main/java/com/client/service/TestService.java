package com.client.service;

import org.slf4j.LoggerFactory;

import com.client.controller.utils.InternalStandardError;

public class TestService {

    private static LoggingService loggingService = new LoggingService(LoggerFactory.getLogger(TestService.class));

    public String get() {
        loggingService.logUserJourney("Executing TestService:get ");
        try {
            System.out.println(1 / 0);
            loggingService.successLog("I0008", "get Service method called");
        } catch (Exception e) {
            loggingService.errorLog(InternalStandardError.INTERNAL_SERVER_ERROR,
                    "Error Occured in LoggingService.get ::" + e.getMessage(), e);
        }

        return "Hello Dhananjay";

    }
}
