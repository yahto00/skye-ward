package com.hydra.skye.ward.model.result;

/**
 * Created by yahto on 13/11/2017
 */
public class DBErrResult extends DataResult {
    public DBErrResult(String err) {
        this.setCode(501);
        this.setMessage("数据库操作失败!" + err);
        this.setData(null);
    }
}
