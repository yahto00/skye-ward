package com.hydra.skye.ward.common.enums;

/**
 * Created by yahto on 21/03/2018
 */
public enum DataCode {
    SUCCESS(200),
    DATABASEERROR(501),
    INVALIDERROR(502),
    SERVICEERROR(503),
    SYSTEMERROR(500),
    NOLOGIN(504);
    private Integer code;

    DataCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
