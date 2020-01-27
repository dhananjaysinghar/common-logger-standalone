package com.common.logger.utils;

public class LogRequestUtils {

    /*
     * public static HttpServletRequest getCurrentRequest() { return
     * ((ServletRequestAttributes)
     * RequestContextHolder.getRequestAttributes()).getRequest(); }
     * 
     * public static String getProduct() { return (String)
     * getCurrentRequest().getAttribute("product"); }
     * 
     * public static String getUid() { // Get teh details from SecurityContextHolder
     * return (String) getCurrentRequest().getAttribute("uId"); }
     * 
     * public static String getConversationId() { return (String)
     * getCurrentRequest().getAttribute("conversationId"); }
     */

    /**
     * public static String getUid() { final Authentication authentication =
     * SecurityContextHolder.getContext().getAuthentication(); if (authentication !=
     * null) { return String.valueOf(authentication.getPrincipal()); } return ""; }
     */
}
