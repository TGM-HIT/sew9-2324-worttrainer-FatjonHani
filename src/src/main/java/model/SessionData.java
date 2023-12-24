package model;

import java.util.HashMap;
import java.util.Map;

public class SessionData {

    private static Map<String, Object> sessionData = new HashMap<>();

    public static Map<String, Object> getSessionData() {
        return sessionData;
    }

    public static void setSessionData(Map<String, Object> sessionData) {
        SessionData.sessionData = sessionData;
    }
}