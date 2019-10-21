package com.zing.vchat.message;


import com.zing.vchat.JsonElement.MessageJson;
import com.zing.vchat.cache.ConversationCache;
import com.zing.vchat.cache.UserCacheInfo;
import com.zing.vchat.cache.UsersCache;

import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

@Singleton
public class MessageDistributor extends Thread {
    private LinkedBlockingQueue<MessageJson> MessageQueue = new LinkedBlockingQueue<>(10000);

    private static MessageDistributor messageDistributor = new MessageDistributor();

    public static MessageDistributor getInstance(){
        return messageDistributor;
    }

    public void putToMessageQueue(MessageJson messageJson) {
        MessageQueue.add(messageJson);
    }

    private MessageDistributor(){
        this.start();
    }

    private void ProcessMessages() {
        try {
            MessageJson messageJson = MessageQueue.take();
            // 根据消息的发送对象和接受对象，分发给用户

            LinkedList<UserCacheInfo> userCacheInfoList = ConversationCache.getUserCacheInfoList(messageJson.getConversationId());
            System.out.println("handing out message from:" + messageJson.getSenderId());
            if (null == userCacheInfoList || userCacheInfoList.isEmpty()) return;
            for (UserCacheInfo userCacheInfo : userCacheInfoList) {
                userCacheInfo.getMassageBox().putToMessageQueue(messageJson);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        System.out.println("MessageDistributor started!");
        while (true) {
            ProcessMessages();
        }
    }

}
