package com.client.service;

import org.slf4j.Logger;

import com.common.logger.rules.LogData;
import com.common.logger.rules.StandardErrors;
import com.common.logger.utils.KibanaLogger;

public class LoggingService {

    private Logger logger;

    public LoggingService(Logger logger) {
        super();
        this.logger = logger;
    }

    public void logUserJourney(String message) {
        KibanaLogger.logUserJourney(logger, message);
    }

    public void successLog(String logCode, String messageDescription) {
        LogData logData = LogDataInfo.buildLogDataInfo("200");
        KibanaLogger.log(logger, logCode, messageDescription, logData);
    }

    public void errorLog(StandardErrors standardError, String messageDescription, Exception ex) {
        LogData logData = LogDataInfo.buildLogDataInfo(standardError.getStatusCode());
        KibanaLogger.log(logger, standardError, messageDescription, logData, ex);
    }
}
