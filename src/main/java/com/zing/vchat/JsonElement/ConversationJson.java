package com.zing.vchat.JsonElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;

@XmlRootElement(name = "ConversationJson")
public class ConversationJson {
    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "members")
    private LinkedList<UserJson> members;

    public ConversationJson(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<UserJson> getMembers() {
        return members;
    }

    public void setMembers(LinkedList<UserJson> members) {
        this.members = members;
    }
}
