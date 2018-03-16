package com.hydra.skye.ward.common.exception;

/**
 * Created by yahto on 01/12/2017
 */
public class DatabaseErrorException extends RuntimeException {
    private static final long serialVersionUID = 944668950190113275L;
    private String msg;

    public DatabaseErrorException(Throwable throwable) {
        super(throwable);
    }

    public DatabaseErrorException(String msg) {
        super(msg);
    }

    public DatabaseErrorException(String msg, Throwable cause) {
        super(msg, cause);
    }


}
