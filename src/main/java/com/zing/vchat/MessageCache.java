package com.zing.vchat;

import java.util.HashMap;
import java.util.Map;

public class MessageCache {

    private static int i=0;

    private static Map<Integer, Message> Messages = new HashMap<>();

    public static Map<Integer, Message> getMessages() {
        return Messages;
    }

    public static void setMessages(Map<Integer, Message> messages) {
        Messages = messages;
    }

    static Message getMessage(Integer id){
        return Messages.get(id);
    }


    synchronized static void putMessage(Message message){
        Messages.put(i++, message);
    }
}
