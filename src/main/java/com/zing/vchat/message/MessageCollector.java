package com.zing.vchat.message;

import com.zing.vchat.JsonElement.MessageJson;

import java.util.concurrent.LinkedBlockingQueue;

public class MessageCollector extends Thread {

    private static LinkedBlockingQueue<MessageJson> MessageQueue = new LinkedBlockingQueue<>(10000);

    public static void putToMessageQueue(MessageJson messageJson) {
        MessageQueue.add(messageJson);
    }

    private void ProcessMessages() {
        try {
            MessageJson messageJson = MessageQueue.take();
            MessageDistributor.putToMessageQueue(messageJson);
            // TODO 发送给消息分发器
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
