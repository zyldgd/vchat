package com.zing.ichat.message;

import com.zing.ichat.Message;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class MessageDistributor {
    private Queue<Message> MessageQueue;

    public MessageDistributor(){
        this.MessageQueue = new ConcurrentLinkedDeque<>();
    }

    public void putToMessageQueue(Message message){
        this.MessageQueue.add(message);
    }

    private Message getFromMessage(){
        if (this.MessageQueue.isEmpty()) return null;
        return this.MessageQueue.remove();
    }

    private void DistributeMessages(){
        Message message = this.getFromMessage();
        // TODO 根据消息的发送对象和接受对象，分发给用户；
    }
}
