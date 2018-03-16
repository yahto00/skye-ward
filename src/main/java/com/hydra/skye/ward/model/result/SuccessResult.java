package com.hydra.skye.ward.model.result;

/**
 * Created by yahto on 13/11/2017
 */
public class SuccessResult extends DataResult {
    public SuccessResult(Object data) {
        this.setCode(200);
        this.setMessage("操作成功");
        this.setData(data);
    }
}
