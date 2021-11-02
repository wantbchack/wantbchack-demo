package com.wantbcahck.common.dto.business;



/**
 * @author wantbchack
 */
public class MyReq {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "MyReq{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
