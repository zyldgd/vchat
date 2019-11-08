package com.zing.vchat.JsonElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "UserJson")
public class UserJson {

    @XmlElement(name = "userId")
    private String userId;

    @XmlElement(name = "username")
    private String username;

    @XmlElement(name = "password")
    private String password;

    @XmlElement(name = "nickname")
    private String nickname;

    @XmlElement(name = "email")
    private String email;

    @XmlElement(name = "avatarPath")
    private String avatarPath;

    @XmlElement(name = "remark")
    private String remark;

    @XmlElement(name = "grade")
    private Integer grade;

    /**
     * 账号状态：0：注销  1：激活
     */
    @XmlElement(name = "active")
    private Boolean active;

    public UserJson(){

    }

    public UserJson(String username, String nickname) {
        this.username = username;
        this.nickname = nickname;
        this.password = "******";
        this.grade = 1;
        this.active = true;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "userId:" + userId +  "  username:" + username +"  password:" + password + "  nickname:" + nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}