package com.lipy.miniapps.miniappslibrary.http.response;

/**
 * Created by lipy on 2017/3/4.
 */

public class ServiceResult<DTO extends DateObj> {

    /**
     * 空数据对象
     */
    private final static ServiceResult empty = new ServiceResult("-1", "");
    /**
     * 业务代码，接口名称
     */
    String tranCode;
    /**
     * 数据实体
     */
    DTO dto;
    private String code;
    private String message;

    public ServiceResult() {
    }

    public ServiceResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ServiceResult build(DateObj dto) {
        ServiceResult result = new ServiceResult("0", "");
        result.dto = dto;
        return result;
    }

    public static ServiceResult ok() {
        return empty;
    }

    public static ServiceResult error(String code, String message) {
        return new ServiceResult(code, message);
    }

    @Override
    public String toString() {
        return "ServiceResult{" +
                ", dto=" + dto +
                ", tranCode='" + tranCode + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DTO getDto() {
        return dto;
    }

    public void setDto(DTO dto) {
        this.dto = dto;
    }


}
