package com.yejg.springbootprofile.service.impl;

import com.yejg.springbootprofile.service.HelloService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author yejg
 * @since 2020-02-17
 */
@Profile(value = {"test2"})
@Service
public class Test2HelloServiceImpl implements HelloService {

    @PostConstruct
    public void init() {
        System.out.println("...Test2HelloServiceImpl...init...");
    }

    @Override
    public void sayHello() {
        System.out.println("...Test2HelloServiceImpl...");
    }
}
