package com.yejg.springbootcondition;

import com.yejg.springbootcondition.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author yejg
 * @since 2020-02-17
 */
@Component
public class OnStartup implements ApplicationRunner {

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Map<String, HelloService> beansOfType = applicationContext.getBeansOfType(HelloService.class);

        System.out.println("----------------------");
        beansOfType.forEach((key, value) -> {
            System.out.println(key + "：" + value);
        });
        System.out.println("----------------------");
    }
}
