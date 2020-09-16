package io.ymq.rabbitmq.direct;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述: 接收者
 * @author: yanpenglei
 * @create: 2017/10/25 0:49
 */
@Component
@RabbitListener(queues = "direct")
public class DirectReceiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("接收者 DirectReceiver," + message);
    }
}


/*
参考：https://www.jianshu.com/p/911d987b5f11

@RabbitListener
    可以标注在类上面，需配合 @RabbitHandler 注解一起使用
    @RabbitListener标注在类上面，表示当有收到消息的时候，就交给 @RabbitHandler 的方法处理，
    具体使用哪个方法处理，根据 MessageConverter 转换后的参数类型


// 也可以直接写在方法上
@RabbitListener(queues = "debug")
public void processMessage(Message bytes) {
    System.out.println(new String(bytes));
}


消息的 content_type 属性表示消息 body 数据以什么数据格式存储，
接收消息除了使用 Message 对象接收消息（包含消息属性等信息）之外，
还可直接使用对应类型接收消息 body 内容，但若方法参数类型不正确会抛异常：
    application/octet-stream：二进制字节数组存储，使用 byte[]
    application/x-java-serialized-object：java 对象序列化格式存储，使用 Object、相应类型（反序列化时类型应该同包同名，否者会抛出找不到类异常）
    text/plain：文本数据类型存储，使用 String
    application/json：JSON 格式，使用 Object、相应类型


使用 @Payload 和 @Headers 注解可以消息中的 body 与 headers 信息
@RabbitListener(queues = "debug")
public void processMessage1(@Payload String body, @Headers Map<String,Object> headers) {
    System.out.println("body："+body);
    System.out.println("Headers："+headers);
}


通过 @RabbitListener 的 bindings 属性声明 Binding
（若 RabbitMQ 中不存在该绑定所需要的 Queue、Exchange、RouteKey 则自动创建，若存在则抛出异常）
@RabbitListener(bindings = @QueueBinding(
        exchange = @Exchange(value = "topic.exchange",durable = "true",type = "topic"),
        value = @Queue(value = "consumer_queue",durable = "true"),
        key = "key.#"
))
public void processMessage1(Message message) {
    System.out.println(message);
}






 */