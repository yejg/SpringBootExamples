package com.yejg.springbootcondition;

import com.yejg.springbootcondition.service.HelloService;
import com.yejg.springbootcondition.service.impl.Test3HelloServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootConditionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConditionApplication.class, args);
    }

    // Test3HelloServiceImpl会被加到容器中
    @ConditionalOnMissingBean(HelloService.class)
    @Bean
    public HelloService helloService() {
        return new Test3HelloServiceImpl();
    }
}
