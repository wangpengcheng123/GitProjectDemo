package com.wang.exception;

public class MyException extends  RuntimeException {
    private  String msg;
    private  String status;

    public MyException(){}

   public MyException(String msg, String status){
            this.msg=msg;
            this.status=status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
