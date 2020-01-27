package com.common.logger.model;

import java.io.Serializable;

import com.common.logger.rules.LogData;
import com.common.logger.rules.Priority;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonMessage implements Serializable {

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

    public static CommonMessage build() {
        return new CommonMessage();
    }

    public CommonMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    public CommonMessage setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
        return this;
    }

    public CommonMessage setServiceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public CommonMessage setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public CommonMessage setAppName(String appName) {
        this.appName = appName;
        return this;
    }

    public CommonMessage setLogCode(String logCode) {
        this.logCode = logCode;
        return this;
    }

    public CommonMessage setHostName(String hostName) {
        this.hostName = hostName;
        return this;
    }

    public CommonMessage setEnv(String env) {
        this.env = env;
        return this;
    }

    public CommonMessage setProduct(String product) {
        this.product = product;
        return this;
    }

    public CommonMessage setServiceImpact(boolean serviceImpact) {
        this.serviceImpact = serviceImpact;
        return this;
    }

    public CommonMessage setPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public CommonMessage setMoreInformation(LogData moreInformation) {
        this.moreInformation = moreInformation;
        return this;
    }

    public CommonMessage setException(Throwable exception) {
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

    public CommonMessage setuId(String uId) {
        this.uId = uId;
        return this;
    }

    public String getStatusCode() {
        return statucCode;
    }

    public CommonMessage setStatusCode(String statucCode) {
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
