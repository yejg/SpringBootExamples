package com.yejg.springbootstartertestusedemo;

import com.yejg.springbootstartertest.service.HelloService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@SpringBootApplication
public class SpringBootStarterTestUseDemoApplication implements ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterTestUseDemoApplication.class, args);
    }

    @Autowired(required = false)
    private HelloService helloService;

    @RequestMapping("/")
    public String index() {
        if(helloService==null){
            return "helloService未加载，返回null";
        }
        return helloService.sayHello();
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }
}

