package com.hydra.skye.ward.common.exception;

/**
 * Created by yahto on 13/11/2017
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -1361439924458198354L;
    private String msg;

    public BusinessException(Throwable throwable) {
        super(throwable);
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
