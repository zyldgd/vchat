package com.zing.vchat;

public enum MessageType{
    UNICAST("unicast"),
    BROADCAST("broadcast");

    private String name;

    MessageType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}