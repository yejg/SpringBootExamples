package com.yejg.springbootstartertest.service;

/**
 * @author yejg
 * @since 2019-02-14
 */
public class HelloService {
    private String msg;

    public String sayHello() {
        return "Hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
