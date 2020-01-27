package com;

import com.client.controller.TestController;

public class LoggerApplication {

    static {
        // System.setProperty("MY_HOME", "C:\\Project\\my_logs");
        // System.setProperty("LOG_FILE", "app");
    }

    public static void main(String[] args) {
        System.out.println(new TestController().get());
    }

}
