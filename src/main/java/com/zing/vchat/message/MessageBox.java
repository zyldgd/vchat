package com.zing.vchat.message;

import com.zing.vchat.JsonElement.MessageJson;
import com.zing.vchat.JsonElement.MessagesJson;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageBox {
    private EventOutput eventOutput;
    private LinkedBlockingQueue<MessageJson> messagesCache = new LinkedBlockingQueue<MessageJson>(50);
    private LinkedBlockingQueue<MessageJson> messageQueue = new LinkedBlockingQueue<>(50);
    private static OutboundEvent outboundEvent = new OutboundEvent.Builder().name("newMessage").data(1).build();

    public MessageBox() {
        ProcessMessages();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void ProcessMessages() {
        System.out.println("[INFO] MessageBox ProcessMessages!");
        new Thread(() -> {
            while (true) {
                try {
                    MessageJson messageJson = messageQueue.take();
                    if (!this.eventOutput.isClosed()) {
                        this.eventOutput.write(new OutboundEvent.Builder().name("newMessage").data(MessageJson.class, messageJson).build());
                    }
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 采用 当收到消息后通过 <strong>EventSource</strong> 直接转发用户
     *
     * @param message 将要处理的消息
     */
    public void ProcessMessage(MessageJson message) {
        new Thread(() -> {
            if (null != this.eventOutput) {
                try {
                    this.eventOutput.write(new OutboundEvent.Builder().name("messagesCache").data(MessageJson.class, message).build());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                if (messagesCache.remainingCapacity() == 0) {
                    messagesCache.remove();
                }
                messagesCache.add(message);
            }
        }).start();
    }

    /**
     * 采用 当收到消息后通过 <strong>EventSource</strong>提醒用户有新的消息
     *
     * @param message 将要处理的消息
     */
    public void ProcessMessage2(MessageJson message) {
        new Thread(() -> {
            if (messagesCache.remainingCapacity() == 0) {
                messagesCache.remove();
            }
            messagesCache.add(message);
            if (null != this.eventOutput) {
                try {
                    eventOutput.write(outboundEvent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public MessagesJson getMessagesCache() {
        MessagesJson messagesJson = new MessagesJson();
        for (int i = 0; i < 50; i++) {
            if (this.messagesCache.isEmpty())
                break;
            messagesJson.putMessage(this.messagesCache.remove());
        }
        return messagesJson;
    }

    public EventOutput getEventOutput() {
        return eventOutput;
    }

    public EventOutput setEventOutput() {
        EventOutput eventOutput = new EventOutput();
        this.eventOutput = eventOutput;
        return eventOutput;
    }

    public void deleteEventOutput() {
        this.eventOutput = null;
    }

    public void putToMessageQueue(MessageJson message) {
        if (messageQueue.remainingCapacity() == 0) {
            messageQueue.remove();
        }
        messageQueue.add(message);
    }
}
