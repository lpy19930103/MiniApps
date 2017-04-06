package com.lipy.miniapps.miniappslibrary.http.request;

/**
 * Created by lipy on 2017/3/4.
 */

public class BusinessRequestParams<DTO> {


    /**
     * 时间戳
     */
    String timestamp;

    /**
     * 报文格式
     */
    String format;

    /**
     * 终端类型 1: Android 2: iOS
     */
    String devType;

    /**
     * 业务代码，接口名称
     */
    String tranCode;

    /**
     * Session ID
     */
    String sid;

    /**
     * 接口对应的参数实体
     */
    DTO dto;

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public DTO getDto() {
        return dto;
    }

    public void setDto(DTO dto) {
        this.dto = dto;
    }

}
