package com.yejg.springbootprofile.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author yejg
 * @since 2020-04-28
 */
@Component
public class RealTestService extends AbstractTestService {


    PrintLog printLog;

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct");
    }

    // @Autowired
    // void setP(PrintLog printLog) {
    //     System.out.println("Autowired...setPrintLog...");
    //     this.printLog = printLog;
    //     super.setPrintLog(printLog);
    // }
}
