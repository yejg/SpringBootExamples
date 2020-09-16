package com.yejg.springbootcondition.service.impl;

import com.yejg.springbootcondition.service.HelloService;

import javax.annotation.PostConstruct;


public class Test3HelloServiceImpl implements HelloService {

    @PostConstruct
    public void init() {
        System.out.println("...Test3HelloServiceImpl...init...");
    }

    @Override
    public void sayHello() {
        System.out.println("...Test3HelloServiceImpl...");
    }
}
