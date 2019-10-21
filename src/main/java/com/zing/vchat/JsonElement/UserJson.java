package com.zing.vchat.JsonElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "UserJson")
public class UserJson {

    @XmlElement(name = "userId")
    private String userId;

    @XmlElement(name = "username")
    private String username;

    @XmlElement(name = "password")
    private String password;

    public UserJson(){

    }

    public UserJson(String userId, String username) {
        this.userId = userId;
        this.username = username;
        this.password = "******";
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "userId:" + userId + " password:" + password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}