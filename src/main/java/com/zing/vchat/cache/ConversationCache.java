package com.zing.vchat.cache;

import com.zing.vchat.base.Token;
import com.zing.vchat.message.MessageBox;
import org.glassfish.jersey.media.sse.EventOutput;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConversationCache {
    /* conversationId  UserCacheInfo[]*/
    private static Map<String, ArrayList<UserCacheInfo>> conversationCache = new ConcurrentHashMap<>();
    private static Map<String, SseBroadcaster> BroadcasterCache = new ConcurrentHashMap<>();
  
    public static void addEventOutput(String conversationId, String userId){
        BroadcasterCache.get(conversationId).add(UsersCache.getEventOutput(userId));
    }

    public static void deleteEventOutput(String conversationId, String userId){
        BroadcasterCache.get(conversationId).remove(UsersCache.getEventOutput(userId));
    }

    public static SseBroadcaster getBroadcaster(String conversationId){
        return BroadcasterCache.get(conversationId);
    }

    public static ArrayList<UserCacheInfo> getUserCacheInfoList(String conversationId){
        return conversationCache.get(conversationId);
    }


   
}
