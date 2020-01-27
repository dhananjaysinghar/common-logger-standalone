package com.common.logger.model;

import java.io.Serializable;

import com.common.logger.rules.LogData;
import com.common.logger.rules.Priority;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(Include.NON_NULL)
public class KibanaMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    private String message;
    private String messageDescription;
    private String serviceId;
    private String serviceName;
    private String appName;
    private String logCode;
    private String hostName;
    private String env;
    private String product;
    private String uId;
    private boolean serviceImpact;
    private Priority priority;
    private LogData moreInformation;
    private Throwable exception;
    private String statucCode;

    public static KibanaMessage build() {
        return new KibanaMessage();
    }

    public KibanaMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    public KibanaMessage setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
        return this;
    }

    public KibanaMessage setServiceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public KibanaMessage setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public KibanaMessage setAppName(String appName) {
        this.appName = appName;
        return this;
    }

    public KibanaMessage setLogCode(String logCode) {
        this.logCode = logCode;
        return this;
    }

    public KibanaMessage setHostName(String hostName) {
        this.hostName = hostName;
        return this;
    }

    public KibanaMessage setEnv(String env) {
        this.env = env;
        return this;
    }

    public KibanaMessage setProduct(String product) {
        this.product = product;
        return this;
    }

    public KibanaMessage setServiceImpact(boolean serviceImpact) {
        this.serviceImpact = serviceImpact;
        return this;
    }

    public KibanaMessage setPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public KibanaMessage setMoreInformation(LogData moreInformation) {
        this.moreInformation = moreInformation;
        return this;
    }

    public KibanaMessage setException(Throwable exception) {
        this.exception = exception;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageDescription() {
        return messageDescription;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getAppName() {
        return appName;
    }

    public String getLogCode() {
        return logCode;
    }

    public String getHostName() {
        return hostName;
    }

    public String getEnv() {
        return env;
    }

    public String getProduct() {
        return product;
    }

    public boolean isServiceImpact() {
        return serviceImpact;
    }

    public Priority getPriority() {
        return priority;
    }

    public LogData getMoreInformation() {
        return moreInformation;
    }

    public Throwable getException() {
        return exception;
    }

    public String getuId() {
        return uId;
    }

    public KibanaMessage setuId(String uId) {
        this.uId = uId;
        return this;
    }

    public String getStatusCode() {
        return statucCode;
    }

    public KibanaMessage setStatusCode(String statucCode) {
        this.statucCode = statucCode;
        return this;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return super.toString();
    }

}
