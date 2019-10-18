package com.zing.vchat.JsonElement;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "MessageJson")
public class MessageJson {

    /**
     * 该消息的ID
     */
    @XmlElement(name = "id")
    private java.lang.String id;

    /**
     * 消息内容
     */
    @XmlElement(name = "content")
    private java.lang.String content;

    /**
     * 日期
     */
    @XmlElement(name = "date")
    private java.lang.String date;

    /**
     * 时间
     */
    @XmlElement(name = "time")
    private java.lang.String time;

    /**
     * 发送者ID
     */
    @XmlElement(name = "senderId")
    private String senderId;

    /**
     * 消息所在的会话ID
     */
    @XmlElement(name = "conversationId")
    private java.lang.String conversationId;

    public java.lang.String getContent() {
        return content;
    }

    public void setContent(java.lang.String content) {
        this.content = content;
    }

    public java.lang.String getDate() {
        return date;
    }

    public void setDate(java.lang.String date) {
        this.date = date;
    }

    public java.lang.String getTime() {
        return time;
    }

    public void setTime(java.lang.String time) {
        this.time = time;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public java.lang.String getConversationId() {
        return conversationId;
    }

    public void setConversationId(java.lang.String conversationId) {
        this.conversationId = conversationId;
    }

    @Override
    public java.lang.String toString() {
        return java.lang.String.format("ID:%s  DATE:%s     FORM:%s    TO:%s     CONTENT:%s",id, date,senderId, conversationId,content);
    }
}
