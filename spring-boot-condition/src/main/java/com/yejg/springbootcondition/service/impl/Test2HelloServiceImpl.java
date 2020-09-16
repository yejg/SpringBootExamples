package com.yejg.springbootcondition.service.impl;

import com.yejg.springbootcondition.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 *
 * <pre>
 *   Test2HelloServiceImpl:
 *     Did not match:
 *      - @ConditionalOnBean (types: com.yejg.springbootcondition.service.HelloService; SearchStrategy: all)
 *      found beans of type 'com.yejg.springbootcondition.service.HelloService' test2HelloServiceImpl (OnBeanCondition)
 *
 *   但是最终没有打印[...Test2HelloServiceImpl...init...]
 *   通过[applicationContext.getBeansOfType(HelloService.class);]也没有取到test2HelloServiceImpl
 * </pre>
 *
 *
 */
@ConditionalOnMissingBean(HelloService.class)
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
