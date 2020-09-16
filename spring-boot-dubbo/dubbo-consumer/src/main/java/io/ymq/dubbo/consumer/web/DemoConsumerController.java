package io.ymq.dubbo.consumer.web;

/**
 * 描述:
 *
 * @author yanpenglei
 * @create 2018-07-25 17:25
 **/

import io.ymq.dubbo.api.DemoService;
import io.ymq.dubbo.consumer.service.ConsumerDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DemoConsumerController {

    @Resource
    private DemoService demoService;

    @Autowired
    private ConsumerDemoService consumerDemoService;

    // http://localhost:8085/sayHello?name=tom
    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        consumerDemoService.sayHello(name);
        return demoService.sayHello(name);
    }
}