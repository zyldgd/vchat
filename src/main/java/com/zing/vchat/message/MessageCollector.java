package com.zing.vchat.message;

import com.zing.vchat.JsonElement.MessageJson;

import javax.inject.Singleton;
import java.util.concurrent.LinkedBlockingQueue;

@Singleton
public class MessageCollector extends Thread {
    private LinkedBlockingQueue<MessageJson> MessageQueue = new LinkedBlockingQueue<>(10000);
    private static MessageCollector messageCollector = new MessageCollector();

    public static MessageCollector getInstance() {
        return messageCollector;
    }

    public void putToMessageQueue(MessageJson messageJson) {
        MessageQueue.add(messageJson);
        System.out.println("get new message from:" + messageJson.getSenderId());
    }

    private MessageCollector() {
        this.start();
    }

    private void ProcessMessages() {
        try {
            MessageJson messageJson = MessageQueue.take();
            MessageDistributor.getInstance().putToMessageQueue(messageJson);
            // TODO 发送给消息分发器 并 添加到数据库中
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        System.out.println("MessageCollector started!");
        while (true) {
            ProcessMessages();
        }
    }
}
