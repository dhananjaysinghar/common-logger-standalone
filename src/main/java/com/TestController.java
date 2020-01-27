package com;

import com.common.logger.utils.LoggingService;

public class TestController {

	private static LoggingService loggingService = LoggingService.getLogger(TestController.class);

	private TestService service = new TestService();

	public String get() {
		loggingService.logUserJourney("Executing TestController:get ");
		loggingService.successLog("I0008", "get method called");
		return service.get();

	}

}
