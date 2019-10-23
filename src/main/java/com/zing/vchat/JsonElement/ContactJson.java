package com.zing.vchat.JsonElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "ContactJson")
public class ContactJson {

    @XmlElement(name = "contactId")
    private String contactId;

    @XmlElement(name = "type")
    private String type;

    @XmlElement(name = "remarkName")
    private String remarkName;


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
}
