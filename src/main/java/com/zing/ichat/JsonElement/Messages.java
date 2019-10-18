package com.zing.ichat.JsonElement;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Messages {
    private ArrayList<Message> messages = new ArrayList<>();
    public Messages(){
    }

    public void putMessage(Message message){
        this.messages.add(message);
    }


}
