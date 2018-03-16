package com.hydra.skye.ward.model.result;

/**
 * Created by yahto on 13/11/2017
 */
public class FailResult extends DataResult {
    public FailResult(String msg) {
        this.setData(null);
        this.setCode(500);
        this.setMessage(msg);
    }
}
