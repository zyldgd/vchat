package com.zing.vchat.cache;

import com.zing.vchat.base.Token;
import com.zing.vchat.message.MessageBox;
import org.glassfish.jersey.media.sse.EventOutput;

import java.io.IOException;

class UserCacheInfo {
    private String userId;
    private Token token;
    private MessageBox massageBox;

    UserCacheInfo(String userId) {
        this.userId = userId;
        this.massageBox = new MessageBox();
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
