package com.zing.ichat.cache;

import com.zing.ichat.Token;
import com.zing.ichat.User;
import com.zing.ichat.message.MessageBox;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UserCache {
    private static UserCache userCache = new UserCache();
    private Map<String, Token> tokens;
    private Map<UUID, String> users;
    private Map<String, MessageBox> messageBoxs;


    public static UserCache getInstance() {
        return UserCache.userCache;
    }

    private UserCache() {
        this.tokens = new ConcurrentHashMap<>();
        this.users = new ConcurrentHashMap<>();
        this.messageBoxs = new ConcurrentHashMap<>();
    }

    public void crateMessageBox(String userId){
        this.messageBoxs.put(userId, new MessageBox());
    }

    public MessageBox getMessageBox(String userId){
         return messageBoxs.get(userId);
    }

    public Token getToken(String userId) {
        return this.tokens.get(userId);
    }

    public void deleteToken(String userId) {
        this.users.remove(this.tokens.get(userId).getToken());
        this.tokens.remove(userId);
    }

    public Token setToken(String userId) {
        Token token = new Token(userId);
        while (users.containsKey(token.getToken())) {
            token = new Token();
        }
        this.users.put(token.getToken(), userId);
        this.tokens.put(userId, token);
        return token;
    }

    public String getUserId(UUID token_uuid) {
        return this.users.get(token_uuid);
    }

    public String getUserId(String token_str) {
        return this.users.get(UUID.fromString(token_str));
    }
}
