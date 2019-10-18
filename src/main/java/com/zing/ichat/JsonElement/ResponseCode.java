package com.zing.ichat.JsonElement;

public enum  ResponseCode {
    OK(200,"ok"),
    ERR(404,"error"),
    FAILED(405,"failed"),
    INEXISTENCE(406,"inexistence");

    private String name;
    private Integer code;

    ResponseCode(Integer code, String name){
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
}
