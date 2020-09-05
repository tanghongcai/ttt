package com.newer.blog.util;

import java.util.List;

public class BizResult<T> {
    T result;
    List<T> list;
    String code;
    String msg;
    boolean success;

    public BizResult() {
    }

    public BizResult(T result, List<T> list, String code, String msg, boolean success) {
        this.result = result;
        this.list = list;
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "BizResult{" +
                "result=" + result +
                ", list=" + list +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                '}';
    }
}
