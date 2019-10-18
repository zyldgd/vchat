package com.zing.vchat.util;

import com.zing.vchat.cache.UsersCache;

import javax.servlet.http.HttpServletRequest;

public class AuthorizationUtils {
    public static boolean isPass(HttpServletRequest request){
        String token_str = request.getHeader("userToken");
        String userId = request.getHeader("userId");
        return UsersCache.getToken(userId).isValid(token_str);
    }

    public static boolean isPass(String userId, String token){
        return UsersCache.getToken(userId).isValid(token);
    }

    public static String getUserId(HttpServletRequest request){
        return request.getHeader("userId");
    }

    public static String getTokenStr(HttpServletRequest request){
        return request.getHeader("userToken");
    }
}
