package com.zing.vchat.util;

import com.zing.vchat.base.HttpHeaderKey;
import com.zing.vchat.cache.UserCacheInfo;
import com.zing.vchat.cache.UsersCache;

import javax.servlet.http.HttpServletRequest;

public class AuthorizationUtils {


    public static boolean isPass(HttpServletRequest request) {
        String userId = request.getHeader(HttpHeaderKey.USER_ID.toString());
        String token_str = request.getHeader(HttpHeaderKey.USER_TOKEN.toString());
        return UsersCache.getToken(userId).isValid(token_str);
    }

    public static boolean isPass(String userId, String token) {
        return UsersCache.getToken(userId).isValid(token);
    }

    public static String getUserId(HttpServletRequest request) {
        return request.getHeader(HttpHeaderKey.USER_ID.toString());
    }

    public static String getTokenStr(HttpServletRequest request) {
        return request.getHeader(HttpHeaderKey.USER_TOKEN.toString());
    }

    public static boolean verify(HttpServletRequest request) {
        String userId = request.getHeader(HttpHeaderKey.USER_ID.toString());
        String password = request.getHeader(HttpHeaderKey.USER_PASSWORD.toString());
        UserCacheInfo userCacheInfo = UsersCache.getUserCacheInfo(userId);
        return (password.equals(userCacheInfo.getUserJson().getPassword()));
    }
}
