package com.zing.vchat.JsonElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GroupJson")
public class GroupJson {

    @XmlElement(name = "groupId")
    private String groupId;

    @XmlElement(name = "groupName")
    private String groupName;

    @XmlElement(name = "date")
    private String date;

    @XmlElement(name = "announcement")
    private String announcement;

    @XmlElement(name = "imagePath")
    private String imagePath;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
