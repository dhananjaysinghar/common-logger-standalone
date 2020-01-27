package com.client.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.common.logger.rules.LogData;

public class LogDataInfo implements LogData {

    private static final long serialVersionUID = 1L;

    private String timeStamp;
    private String responseCode;
    private Map<String, String> requestHeaders;
    private String requestUrl;
    private String uId;
    private String conversationId;
    private Map<String, String> additionalParam = new HashMap<String, String>();

    private LogDataInfo() {
        super();
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public static LogDataInfo buildLogDataInfo(String responseCode) {
        LogDataInfo logData = new LogDataInfo();
        logData.setTimeStamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
       // logData.setuId(LogRequestUtils.getUid());
        //logData.setConversationId(LogRequestUtils.getConversationId());
        //logData.setRequestHeaders(request);
      //  logData.setRequestUrl(request.getRequestURI());
        logData.setResponseCode(responseCode);
        return logData;
    }

    public LogData aditionalParam(String key, String value) {
        additionalParam.put(key, value);
        return this;
    }

    public Map<String, String> getAdditionalParam() {
        return additionalParam;
    }
}
