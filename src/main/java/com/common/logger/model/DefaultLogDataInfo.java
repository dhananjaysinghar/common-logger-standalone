package com.common.logger.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Map;

import com.common.logger.rules.LogData;

public class DefaultLogDataInfo implements LogData {

    private static final long serialVersionUID = 1L;

    private String responseCode;

    public DefaultLogDataInfo(String responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public String getResponseCode() {
        return responseCode;
    }

    @Override
    public Map<String, String> getRequestHeaders() {
        return null;
    }

    @Override
    public String getRequestUrl() {
        return null;
    }

    @Override
    public String getTimeStamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    }

    @Override
    public Map<String, String> getAdditionalParam() {
        return Collections.emptyMap();
    }

    public static LogData buildLogDataInfo(String responseCode) {
        return new DefaultLogDataInfo(responseCode);

    }

}
