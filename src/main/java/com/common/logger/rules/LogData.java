package com.common.logger.rules;

import java.io.Serializable;

public interface LogData extends Serializable {

	String getResponseCode();

	String getTimeStamp();
	
	String getConversationId();

}
