package com.yejg.springbootstartertest.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yejg
 * @since 2019-02-14
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {

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
