package com.common.logger.utils;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.MDC;

import com.common.logger.model.CommonMessage;
import com.common.logger.rules.LogData;
import com.common.logger.rules.StandardErrors;

import ch.qos.logback.classic.Level;

public class CommonLogger {

	private static final String SUCCESS_MESSAGE = "SUCCESS";

	/**
	 * This Method will use for debug message
	 * 
	 * @param logger
	 * @param message
	 */
	public static void logUserJourney(Logger logger, String message) {
		crefreshAdditionalIndex();
		MDC.put("conversationId", ConversationIdGenerator.getConversationId());
		logger.debug(message);
	}

	/**
	 * This method will use for success message.
	 * 
	 * @param logger
	 * @param config
	 * @param logCode
	 * @param messageDescription
	 */
	public static void log(Logger logger, String logCode, String messageDescription, LogData logData) {

		CommonMessage message = setCommonData(logCode, messageDescription, logData)
				.setMessage(SUCCESS_MESSAGE)
				.setStatusCode("200")
				.setServiceImpact(false);

		Level level = determineLoglevel(logCode);
		addAdditionalIndex(message);
		log(logger, level, message.toString());
	}

	/**
	 * This method will use for error message.
	 * 
	 * @param logger
	 * @param config
	 * @param standardError
	 * @param messageDescription
	 * @param ex
	 */
	public static void log(Logger logger, StandardErrors standardError, String messageDescription, LogData logData,
			Exception ex) {

		CommonMessage message = setCommonData(standardError.getLogCode(), messageDescription, logData)
				.setMessage(standardError.getMessage())
				.setStatusCode(standardError.getStatusCode())
				.setServiceImpact(true)
				.setPriority(standardError.getPriority())
				.setException(ex);

		Level level = determineLoglevel(standardError.getLogCode());
		addAdditionalIndex(message);
		log(logger, level, message.toString(), message.getException());
	}

	private static CommonMessage setCommonData(String logCode, String messageDescription, LogData logData) {
		MDC.put("conversationId", ConversationIdGenerator.getConversationId());
		return CommonMessage.build()
				.setLogCode(logCode)
				.setMessageDescription(messageDescription)
				.setMoreInformation(logData);
	}

	/**
	 * add extra parameter to logback logs
	 * 
	 * @param level
	 * @param message
	 */
	private static void addAdditionalIndex(CommonMessage message) {
		/**
		 * MDC.put("logCode", message.getLogCode()); MDC.put("appName",
		 * message.getAppName()); MDC.put("statusCode",
		 * message.getStatusCode()); MDC.put("serviceImpact",
		 * Boolean.toString((message.isServiceImpact()))); MDC.put("priority",
		 * message.getPriority() != null ? message.getPriority().toString() :
		 * "");
		 * 
		 * if (Optional.ofNullable(message.getMoreInformation()).isPresent()) {
		 * Map<String, String> additionalParam =
		 * message.getMoreInformation().getAdditionalParam();
		 * additionalParam.keySet().forEach(e -> MDC.put(e,
		 * additionalParam.get(e))); }
		 */
	}

	private static void crefreshAdditionalIndex() {
		/** MDC.clear(); */
	}

	private static void log(Logger logger, Level level, String logMessage, Throwable... exception) {
		switch (level.levelStr) {
		case "ERROR":
			logErrorMessage(logger, logMessage, exception);
			break;
		case "WARN":
			logger.warn(logMessage);
			break;
		case "INFO":
			logger.info(logMessage);
			break;
		case "DEBUG":
			logger.debug(logMessage);
			break;
		default:
			logger.info(logMessage);
			break;
		}
	}

	private static void logErrorMessage(Logger logger, String logMessage, Throwable... exception) {
		if (exception != null && exception.length > 0) {
			logger.error(logMessage, exception[0]);
		} else {
			logger.error(logMessage);
		}
	}

	private static Level determineLoglevel(String logCode) {
		return LogEnums.getlogLevel(logCode);
	}

	enum LogEnums {

		SUCCESS("I", Level.INFO), ERROR("E", Level.ERROR), WARN("W", Level.WARN);

		private final String logCode;
		private final Level level;

		LogEnums(String logCode, Level level) {
			this.logCode = logCode;
			this.level = level;
		}

		String getLogCode() {
			return logCode;
		}

		Level getLevel() {
			return level;
		}

		public static Level getlogLevel(String logCode) {
			String logFLetter = logCode != null ? logCode.substring(0, 1) : "";
			return Arrays.stream(LogEnums.values())
					.filter(e -> e.getLogCode().equalsIgnoreCase(logFLetter))
					.findFirst()
					.orElse(WARN)
					.getLevel();
		}
	}
}
