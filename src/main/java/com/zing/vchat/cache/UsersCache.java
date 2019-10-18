package com.zing.vchat.cache;

import com.zing.vchat.base.Token;
import com.zing.vchat.message.MessageBox;
import org.glassfish.jersey.media.sse.EventOutput;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UsersCache {
    private static Map<String, UserCacheInfo> usersCacheInfo = new ConcurrentHashMap<>();

    public static void crateUserCacheInfo(String userId){
        usersCacheInfo.put(userId, new UserCacheInfo(userId));
    }

    public static void deleteToken(String userId) {
        usersCacheInfo.get(userId).deleteToken();
    }

    public static Token getToken(String userId){
        UserCacheInfo info = usersCacheInfo.get(userId);
    //        if (null == info) return null;
        return info.getToken();
    }

    public static Token setToken(String userId){
        return usersCacheInfo.get(userId).setToken();
    }

    public static MessageBox getMessageBox(String userId){
        return usersCacheInfo.get(userId).getMassageBox();
    }

    public static EventOutput getEventOutput(String userId){
        return usersCacheInfo.get(userId).getEventOutput();
    }

    public static EventOutput setEventOutput(String userId){
        return usersCacheInfo.get(userId).setEventOutput();
    }

    public static void deleteEventOutput(String userId){
        usersCacheInfo.get(userId).deleteEventOutput();
    }
}
