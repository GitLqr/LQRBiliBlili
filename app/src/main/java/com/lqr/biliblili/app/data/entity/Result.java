package com.lqr.biliblili.app.data.entity;

/**
 * @创建者 CSDN_LQR
 * @描述 本来想用这种方式来包裹数据，结果跟rxCache掉坑了，所以舍弃。。。
 */
public class Result<T> {

    int code;
    String msg;
    String message;
    T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
