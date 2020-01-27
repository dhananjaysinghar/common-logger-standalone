package com.client.controller;

import org.slf4j.LoggerFactory;

import com.client.service.LoggingService;
import com.client.service.TestService;

public class TestController {

    private static LoggingService loggingService = new LoggingService(LoggerFactory.getLogger(TestController.class));

    private TestService service = new TestService();

    public String get() {

        loggingService.logUserJourney("Executing TestController:get ");
        loggingService.successLog("I0008", "get method called");
        return service.get();

    }

}
