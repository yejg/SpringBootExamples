package io.ymq.dubbo.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import io.ymq.dubbo.api.DemoService;

/**
 * @author yejg
 * @since 2020-04-28
 */
public abstract class AbstractTestService {

    @Reference
    private DemoService demoService;

    public void doSomething() {
        demoService.sayHello("hahah。。。。");
    }

}
