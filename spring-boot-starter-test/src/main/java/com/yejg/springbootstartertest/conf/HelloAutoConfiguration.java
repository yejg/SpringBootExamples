package com.yejg.springbootstartertest.conf;

/**
 * @author yejg
 * @since 2019-02-14
 */

import com.yejg.springbootstartertest.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = HelloServiceProperties.class)
/**
 * <pre>
 * 配置多个 @Condition的时候，他们之间是 【与】的关系，在application.properties中配置【debug=true】可以看到日志
 *
 * eg：配置hello.enable为false，启动的时候会打印如下日志，最终HelloAutoConfiguration没被加载
 *
 *    HelloAutoConfiguration:
 *    Did not match:
 *      - @ConditionalOnProperty (hello.enable) found different value in property 'enable' (OnPropertyCondition)
 *    Matched:
 *      - @ConditionalOnClass found required class 'com.yejg.springbootstartertest.service.HelloService' (OnClassCondition)
 * </pre>
 *
 * */
@ConditionalOnClass(HelloService.class)
@ConditionalOnProperty(prefix = "hello", value = "enable", matchIfMissing = true)
public class HelloAutoConfiguration {

    @Autowired
    private HelloServiceProperties helloServiceProperties;

    @Bean
    @ConditionalOnMissingBean(HelloService.class)
    public HelloService helloService() {
        HelloService helloService = new HelloService();
        helloService.setMsg(helloServiceProperties.getMsg());
        return helloService;
    }
}
