package com.zing.vchat.JsonElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "UserJson")
public class UserJson {

    @XmlElement(name = "username")
    private String username;

    @XmlElement(name = "password")
    private String password;


    public UserJson(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "username:" + username + " password:" + password;
    }
}