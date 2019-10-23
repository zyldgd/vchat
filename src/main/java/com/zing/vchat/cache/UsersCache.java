package com.zing.vchat.cache;

import com.zing.vchat.JsonElement.UserJson;
import com.zing.vchat.base.Token;
import com.zing.vchat.dao.UsersDao;
import com.zing.vchat.message.MessageBox;
import org.glassfish.jersey.media.sse.EventOutput;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UsersCache {
    private static Map<String, UserCacheInfo> usersCacheInfo = new ConcurrentHashMap<>(1000);

    public static void crateUserCacheInfo(UserJson userJson) {
        if (usersCacheInfo.containsKey(userJson.getUserId())) return;
        usersCacheInfo.put(userJson.getUserId(), new UserCacheInfo(userJson));
    }

    public static void deleteToken(String userId) {
        usersCacheInfo.get(userId).deleteToken();
    }

    public static Token getToken(String userId) {
        UserCacheInfo info = usersCacheInfo.get(userId);
        //        if (null == info) return null;
        return info.getToken();
    }

    public static Token setToken(String userId) {
        return usersCacheInfo.get(userId).setToken();
    }

    public static MessageBox getMessageBox(String userId) {
        return usersCacheInfo.get(userId).getMassageBox();
    }

    public static EventOutput getEventOutput(String userId) {
        return usersCacheInfo.get(userId).getEventOutput();
    }

    public static EventOutput setEventOutput(String userId) {
        return usersCacheInfo.get(userId).setEventOutput();
    }

    public static void deleteEventOutput(String userId) {
        usersCacheInfo.get(userId).deleteEventOutput();
    }

    public static UserCacheInfo getUserCacheInfo(String userId) {
        return usersCacheInfo.get(userId);
    }

    public static void init() {
        usersCacheInfo.clear();
        System.out.println("UsersCache init start!");
        for (UserJson userJson : UsersDao.getAll()) {
            UsersCache.crateUserCacheInfo(userJson);
            System.out.println(userJson);
        }
        System.out.println("UsersCache init end!");
    }
}
