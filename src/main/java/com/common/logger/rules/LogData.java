package com.common.logger.rules;

import java.io.Serializable;
import java.util.Map;

public interface LogData extends Serializable {

    String getResponseCode();

    Map<String, String> getRequestHeaders();

    String getRequestUrl();

    String getTimeStamp();

    Map<String, String> getAdditionalParam();

}
