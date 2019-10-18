package com.zing.vchat.JsonElement;

import com.zing.vchat.base.ResponseCode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "ResponseCodeJson")
public class ResponseCodeJson {

    @XmlElement(name = "code")
    private Integer code;
    @XmlElement(name = "meaning")
    private String meaning;

    ResponseCodeJson(ResponseCode responseCode){
        this.code = responseCode.getCode();
        this.meaning = responseCode.getMeaning();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
