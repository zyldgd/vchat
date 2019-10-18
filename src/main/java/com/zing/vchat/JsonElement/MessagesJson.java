package com.zing.vchat.JsonElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "MessagesJson")
public class MessagesJson {

    @XmlElement(name = "messages")
    private ArrayList<MessageJson> messages = new ArrayList<>();

    public void putMessage(MessageJson message){
        this.messages.add(message);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (MessageJson m: messages) {
            stringBuilder.append(m).append("\n");
        }
        return stringBuilder.toString();
    }
}
