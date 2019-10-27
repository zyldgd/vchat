package com.zing.vchat.message;


import com.zing.vchat.JsonElement.MessageJson;
import com.zing.vchat.cache.ConversationCache;
import com.zing.vchat.cache.UserCacheInfo;
import com.zing.vchat.cache.UsersCache;
import com.zing.vchat.dao.GroupDao;

import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

@Singleton
public class MessageDistributor extends Thread {
    private LinkedBlockingQueue<MessageJson> MessageQueue = new LinkedBlockingQueue<>(10000);

    private static MessageDistributor messageDistributor = new MessageDistributor();

    public static MessageDistributor getInstance() {
        return messageDistributor;
    }

    public void putToMessageQueue(MessageJson messageJson) {
        MessageQueue.add(messageJson);
    }

    private MessageDistributor() {
        this.start();
    }

    private void ProcessMessages() {
        try {
            MessageJson messageJson = MessageQueue.take();
            // 私聊 or 群聊
            if (messageJson.getMessageType().equals("private")){
                String receiverId = messageJson.getReceiverId();
                UsersCache.getMessageBox(receiverId).ProcessMessage(messageJson);
            }else{
                String receiverId = messageJson.getReceiverId();
                LinkedList<String> memberIds = GroupDao.getAllMemberId(receiverId);
                if (memberIds != null) {
                    for (String memberId :memberIds) {
                        UsersCache.getMessageBox(memberId).ProcessMessage(messageJson);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        System.out.println("[INFO] MessageDistributor started!");
        while (true) {
            ProcessMessages();
        }
    }

}
