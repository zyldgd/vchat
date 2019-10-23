package com.zing.vchat.JsonElement;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "MessageJson")
public class MessageJson {

    /**
     * 消息ID
     */
    @XmlElement(name = "messageHash")
    private String messageHash;

    /**
     * 消息内容
     */
    @XmlElement(name = "content")
    private String content;

    /**
     * 日期
     */
    @XmlElement(name = "date")
    private String date;

    /**
     * 时间
     */
    @XmlElement(name = "time")
    private String time;

    /**
     * 发送者ID
     */
    @XmlElement(name = "senderId")
    private String senderId;

    /**
     * 接受者ID
     */
    @XmlElement(name = "receiverId")
    private String receiverId;
    /**
     * 接受者类型
     */
    @XmlElement(name = "messageType")
    private String messageType;

    public void setMessageHash(String messageHash) {
        this.messageHash = messageHash;
    }

    public String getMessageHash() {
        return this.messageHash;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    @Override
    public String toString() {
        return String.format("ID:%s    DATE:%s     FORM:%s    TO:%s     CONTENT:%s", messageHash, date, senderId, receiverId, content);
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverId() {
        return this.receiverId;
    }
}
