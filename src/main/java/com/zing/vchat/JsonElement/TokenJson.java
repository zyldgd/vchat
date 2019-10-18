package com.zing.vchat.JsonElement;

import com.zing.vchat.base.Token;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "TokenJson")
public class TokenJson {

    @XmlElement(name = "userId")
    private String userId;

    @XmlElement(name = "token")
    private String token;


    public TokenJson(String userId, Token token) {
        this.userId = userId;
        this.token = token.getToken().toString();
    }

    public TokenJson(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "userId:" + userId + " token:" + token;
    }
}