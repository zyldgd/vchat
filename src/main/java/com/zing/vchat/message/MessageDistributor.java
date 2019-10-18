package com.zing.vchat.message;


import com.zing.vchat.JsonElement.MessageJson;

import java.util.concurrent.LinkedBlockingQueue;

public class MessageDistributor extends Thread {
    private static LinkedBlockingQueue<MessageJson> MessageQueue = new LinkedBlockingQueue<>(10000);


    public static void putToMessageQueue(MessageJson message){
        MessageQueue.add(message);
    }

    private void ProcessMessages(){
        try {
            MessageJson messageJson = MessageQueue.take();
            // TODO 根据消息的发送对象和接受对象，分发给用户
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        while (true) {
            ProcessMessages();
        }
    }

}
