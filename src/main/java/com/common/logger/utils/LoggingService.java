package com.common.logger.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.common.logger.rules.LogData;
import com.common.logger.rules.StandardErrors;

public class LoggingService {

	private Logger logger;

	private LoggingService(Logger logger) {
		super();
		this.logger = logger;
	}

	public static LoggingService getLogger(Class<?> classType) {
		return new LoggingService(LoggerFactory.getLogger(classType));

	}

	public void logUserJourney(String message) {
		CommonLogger.logUserJourney(logger, message);
	}

	public void successLog(String logCode, String messageDescription) {
		LogData logData = LogDataInfo.buildLogDataInfo("200", ConversationIdGenerator.getConversationId());
		CommonLogger.log(logger, logCode, messageDescription, logData);
	}

	public void errorLog(StandardErrors standardError, String messageDescription, Exception ex) {
		LogData logData = LogDataInfo.buildLogDataInfo(standardError.getStatusCode(), ConversationIdGenerator.getConversationId());
		CommonLogger.log(logger, standardError, messageDescription, logData, ex);
	}
}
