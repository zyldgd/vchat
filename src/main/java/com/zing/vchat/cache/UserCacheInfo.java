package com.zing.vchat.cache;

import com.zing.vchat.base.Token;
import com.zing.vchat.message.MessageBox;
import org.glassfish.jersey.media.sse.EventOutput;

import java.io.IOException;

class UserCacheInfo {
    private UserJson userJson;
    private Token token;
    private MessageBox massageBox;

    UserCacheInfo(UserJson userJson) {
        this.userJson = userJson;
        this.massageBox = new MessageBox();
        System.out.println("UserCacheInfo install");
    }

    void deleteEventOutput() {
        try {
            this.massageBox.getEventOutput().close();
            this.massageBox.deleteEventOutput();
        } catch (IOException | NullPointerException e) {
            System.out.println("NullPointerException");
        }
    }

    EventOutput getEventOutput() {
        return this.massageBox.getEventOutput();
    }

    EventOutput setEventOutput() {
        deleteEventOutput();
        return this.massageBox.setEventOutput();
    }

    void deleteToken(){
        token = null;
    }

    Token getToken() {
        return this.token;
    }

    Token setToken() {
        this.token = new Token();
        return this.token;
    }

    MessageBox getMassageBox() {
        return this.massageBox;
    }

}
