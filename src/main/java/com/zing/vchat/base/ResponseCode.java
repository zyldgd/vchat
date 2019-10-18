package com.zing.vchat.base;


public enum  ResponseCode {
    OK(200,"ok"),
    SUCCEED(204,"succeed"),
    ERR(404,"error"),
    FAIL(405,"fail"),
    INEXISTENCE(406,"inexistence");

    private Integer code;
    private String meaning;

    ResponseCode(Integer code, String meaning){
        this.meaning = meaning;
        this.code = code;
    }

    public String getMeaning() {
        return meaning;
    }

    public Integer getCode() {
        return code;
    }
}
