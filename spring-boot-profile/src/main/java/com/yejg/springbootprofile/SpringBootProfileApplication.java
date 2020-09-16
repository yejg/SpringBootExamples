package com.yejg.springbootprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringBootProfileApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringBootProfileApplication.class);
        Map<String, Object> defProperties = new HashMap<>();
        defProperties.put(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "test2");
        application.setDefaultProperties(defProperties);
        // 启动
        application.run(args);
    }

}
