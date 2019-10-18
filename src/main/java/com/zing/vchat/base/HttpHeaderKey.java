package com.zing.vchat.base;

public enum HttpHeaderKey {
    USER_ID("user_id"),
    USER_PASSWORD("user_password"),
    USER_TOKEN("user_token");

    private String Key;

    HttpHeaderKey(String Key){
        this.Key = Key;
    }

    private String getKey() {
        return Key;
    }

    @Override
    public String toString() {
        return getKey();
    }
}
