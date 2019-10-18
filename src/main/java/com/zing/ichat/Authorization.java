package com.zing.ichat;

import java.util.HashMap;
import java.util.Map;

public class Authorization {
    private static Map<String, User> userMap = new HashMap<>();

    public static User getUser(String token){
        return userMap.get(token);
    }

    public static void putUser(String token, User user){
        userMap.put(token, user);
    }
}
