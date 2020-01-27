package com.common.logger.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.common.logger.rules.LogData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LogDataInfo implements LogData {

	private static final long serialVersionUID = 1L;

	private String timeStamp;
	private String responseCode;
	private String conversationId;

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getConversationId() {
		return conversationId;
	}

	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}

	public static LogDataInfo buildLogDataInfo(String responseCode, String conversationId) {
		LogDataInfo logData = new LogDataInfo();
		logData.setTimeStamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
		logData.setResponseCode(responseCode);
		logData.setConversationId(conversationId);
		return logData;
	}
}
