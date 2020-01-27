package com;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import com.client.controller.TestController;
import com.common.logger.utils.LoggingService;

public class LoggerApplication {

	private static LoggingService loggingService = LoggingService.getLogger(LoggerApplication.class);

	public static void main(String[] args) {
		IntStream.range(0, 10).forEach(e -> {
			new Thread(() -> {
				loggingService.logUserJourney(new TestController().get());
			}).start();
			try {
				TimeUnit.SECONDS.sleep(5);
				System.out.println("===================");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}

}
