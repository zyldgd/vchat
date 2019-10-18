package com.zing.ichat.message;

import com.zing.ichat.JsonElement.Message;
import com.zing.ichat.JsonElement.Messages;
import com.zing.ichat.cache.EventSourceCache;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class MessageBox {
    private String userId;
    private Queue<Message> messages;
    private static OutboundEvent outboundEvent = new OutboundEvent.Builder().name("newMessage").data(1).build();

    public MessageBox() {
        this.messages = new ConcurrentLinkedDeque<>();
    }


    /**
     * 采用 当收到消息后通过 <strong>EventSource</strong> 直接转发用户
     * @param message 将要处理的消息
     */
    public void ProcessMessage(Message message) {
        new Thread(() -> {
            //messages.add(message);
            EventOutput eventOutput = EventSourceCache.getInstance().getEventOutput(userId);
            if (null != eventOutput) {
                try {
                    //eventOutput.write(outboundEvent);
                    eventOutput.write(new OutboundEvent.Builder().name("messages").data(Message.class, message).build());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                messages.add(message);
            }
        }).start();
    }

    /**
     * 采用 当收到消息后通过 <strong>EventSource</strong>提醒用户有新的消息
     * @param message 将要处理的消息
     */
    public void ProcessMessage2(Message message) {
        new Thread(() -> {
            messages.add(message);
            EventOutput eventOutput = EventSourceCache.getInstance().getEventOutput(userId);
            if (null != eventOutput) {
                try {
                    eventOutput.write(outboundEvent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public Messages getMessages(){
        Messages messages = new Messages();
        for (int i = 0; i < 10; i++) {
            if (this.messages.isEmpty())
                break;
            messages.putMessage(this.messages.remove());
        }
        return messages;
    }
}
