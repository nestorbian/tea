package com.jstu.tea.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
    public static final Logger logger = LoggerFactory.getLogger(LogUtil.class);
    public static void LogMessage(String message) {
        logger.error("Message: " + message);
    }

    public static void LogMessageAndError(Exception e) {
        logger.error("Messager: " + e.getMessage() + " \nError Content: " + e.getStackTrace());
    }

}
