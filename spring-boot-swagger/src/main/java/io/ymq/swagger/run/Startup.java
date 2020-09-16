package io.ymq.swagger.run;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import io.ymq.swagger.service.HelloService;
import io.ymq.swagger.service.impl.Test2HelloServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 描述:启动服务
 *
 * @author yanpenglei
 * @create 2017-10-26 16:37
 **/
@SpringBootApplication
@ComponentScan(value = {"io.ymq.swagger"})
public class Startup {

    public static void main(String[] args) {
        SpringApplication.run(Startup.class, args);

        /**
         * 网上写的 http://127.0.0.1:8080/swagger-v2/docs.html
         *
         * 中文 http://127.0.0.1:8080/swagger/index.html
         *
         * 默认  http://127.0.0.1:8080/swagger-ui.html
         *
         * 在浏览器：http://127.0.0.1:8080/v2/api-docs  生成  swagger.yaml 文件内容
         *
         */
    }


    @ConditionalOnMissingBean(HelloService.class)
    @Bean
    public HelloService helloService(){
        return new Test2HelloServiceImpl();
    }




    @Bean("defaultFastJsonConfig")
    public FastJsonConfig fastJsonConfig() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse);

        fastJsonConfig.setSerializeFilters(new ValueFilter() {
            @Override
            public Object process(Object obj, String name, Object v) {
                if (v == null) {
                    if (obj instanceof Map) {
                        return "";
                    }
                    Field field = ReflectionUtils.findField(obj.getClass(), name);
                    if (field != null) {
                        if (Map.class.equals(field.getType())) {
                            return Collections.emptyMap();
                        } else if (String.class.equals(field.getType())) {
                            return "";
                        }
                    }
                }
                return v;
            }
        });
        return fastJsonConfig;
    }


    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig());
        return new HttpMessageConverters(fastJsonHttpMessageConverter);
    }
}
