package com.zing.vchat.JsonElement;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "MessageJson")
public class MessageJson {

    /**
     * 该消息的ID
     */
    @XmlElement(name = "id")
    private String id;

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
     * 消息所在的会话ID
     */
    @XmlElement(name = "conversationId")
    private String conversationId;

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

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    @Override
    public String toString() {
        return String.format("ID:%s  DATE:%s     FORM:%s    TO:%s     CONTENT:%s",id, date,senderId, conversationId,content);
    }
}
