package com.puente.challenge.config;

public class ConstraintViolationsUtils {

    public static boolean isConstraintViolationOnField(Throwable ex, String fieldName) {
        while (ex != null) {
            String message = ex.getMessage();
            if (message != null && message.toLowerCase().contains(fieldName.toLowerCase())) {
                return true;
            }
            ex = ex.getCause();
        }
        return false;
    }
}
