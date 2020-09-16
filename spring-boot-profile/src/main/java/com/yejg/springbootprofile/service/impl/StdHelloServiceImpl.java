package com.yejg.springbootprofile.service.impl;

import com.yejg.springbootprofile.service.HelloService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author yejg
 * @since 2020-02-17
 */
// @Profile(value = {"!test1", "!test2"}) // 满足任意一个条件["!test1"||"!test2"]，就会被加载
// @Service
public class StdHelloServiceImpl implements HelloService {

    @PostConstruct
    public void init() {
        System.out.println("...StdHelloServiceImpl...init...");
    }

    @Override
    public void sayHello() {
        System.out.println("...StdHelloServiceImpl...");
    }
}
