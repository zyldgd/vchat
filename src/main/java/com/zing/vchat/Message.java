package com.zing.vchat;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Message {
    private String content;
    private String date;
    private String time;
    private String source;
    private String destination;
    private MessageType messageType;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return String.format("DATE:%s     FORM:%s    TO:%s     CONTENT:%s",date,source,destination,content);
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
