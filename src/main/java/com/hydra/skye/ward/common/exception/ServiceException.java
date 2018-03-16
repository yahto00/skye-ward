package com.hydra.skye.ward.common.exception;

/**
 * Created by yahto on 16/03/2018
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -1361439924458198354L;
    private String msg;

    public ServiceException(Throwable throwable) {
        super(throwable);
    }

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
