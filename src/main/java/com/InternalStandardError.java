package com;

import com.common.logger.rules.Priority;
import com.common.logger.rules.StandardErrors;

public enum InternalStandardError implements StandardErrors {

    INTERNAL_SERVER_ERROR("500", "E5051", "Technical Error occured", Priority.CRITICAL),
    USER_DETAILS_NOT_FOUND("400", "E5052", "Please check the request parameters", Priority.NORMAL);

    private String statusCode;
    private String logCode;
    private String message;
    private Priority priority;

    private InternalStandardError(String statusCode, String logCode, String message, Priority priority) {
        this.statusCode = statusCode;
        this.logCode = logCode;
        this.message = message;
        this.priority = priority;

    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getLogCode() {
        return logCode;
    }

    public String getMessage() {
        return message;
    }

    public Priority getPriority() {
        return priority;
    }

}
