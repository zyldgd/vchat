package com.zing.ichat.message;

import com.zing.ichat.Message;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class MessageCollector extends Thread{
    private Queue<Message> MessageQueue;

    public MessageCollector(){
        this.MessageQueue = new ConcurrentLinkedDeque<>();
    }

    public void putToMessageQueue(Message message){
        this.MessageQueue.add(message);
    }

    private Message getFromMessage(){
        if (this.MessageQueue.isEmpty()) return null;
        return this.MessageQueue.remove();
    }

    private void ProcessMessages(){
        if (!this.MessageQueue.isEmpty()){
            //TODO 发送给数据库，并发给消息分发器
        }
    }

    @Override
    public void run() {
        ProcessMessages();
    }
}
