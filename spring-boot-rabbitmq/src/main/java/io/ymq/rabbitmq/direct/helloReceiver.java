package io.ymq.rabbitmq.direct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author yanpenglei
 * @create 2017-10-25 0:47
 **/
@Component
@RabbitListener(queues = "hello")
public class helloReceiver {

    Logger logger = LoggerFactory.getLogger(helloReceiver.class);

    @RabbitHandler
    public void process(String message) {
        System.out.println("接收者 helloReceiver," + message);
        logger.info("接收者 helloReceiver[{}]", message);
    }
}
