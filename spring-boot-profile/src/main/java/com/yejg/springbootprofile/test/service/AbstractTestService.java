package com.yejg.springbootprofile.test.service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author yejg
 * @since 2020-04-28
 */
public abstract class AbstractTestService {

    @Autowired
    private PrintLog printLog;// 可以注入成功

    protected void setPrintLog(PrintLog printLog) {
        this.printLog = printLog;
    }

    @PostConstruct
    public void printLog() {
        System.out.println("-------------");
        System.out.println(printLog);
        printLog.printLog();
    }
}
