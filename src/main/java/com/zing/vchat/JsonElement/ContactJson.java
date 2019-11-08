package com.zing.vchat.JsonElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "ContactJson")
public class ContactJson {

    @XmlElement(name = "contactId")
    private String contactId;

    @XmlElement(name = "peerId")
    private String peerId;

    @XmlElement(name = "type")
    private String type;

    @XmlElement(name = "remarkName")
    private String remarkName;

    public ContactJson() {
    }

    public ContactJson(String contactId, String peerId, String type, String remarkName) {
        this.contactId = contactId;
        this.peerId = peerId;
        this.type = type;
        this.remarkName = remarkName;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public String getPeerId() {
        return peerId;
    }

    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }

    @Override
    public String toString() {
        return String.format("contactId:%-10s   peerId:%-10s   type:%-10s   remarkName:%-10s", contactId, peerId, type, remarkName);
    }
}
