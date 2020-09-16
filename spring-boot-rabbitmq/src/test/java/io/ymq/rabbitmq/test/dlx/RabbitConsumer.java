package io.ymq.rabbitmq.test.dlx;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * RabbitMQ 消息消费者
 */
public class RabbitConsumer {

    private static final String QUEUE_NAME = "dlx.queue";
    private static final String IP_ADDRESS = "127.0.0.1";
    private static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Address[] addresses = new Address[]{new Address(IP_ADDRESS, PORT)};
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");

        // 这里不写try-resource 是为了让程序不自动退出
        //try (
                // 注意此时获取连接的方式和生产者略有不同
                Connection connection = connectionFactory.newConnection(addresses);
        // ) {
            // 创建信道
            Channel channel = connection.createChannel();
            // 消费端消息限流。
            // 设置客户端最多接收未被ack的消息个数, 只有消息 手动签收  此参数才会生效。
            channel.basicQos(64);
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    System.err.println(time + " 接收到消息：" + new String(body, StandardCharsets.UTF_8));
                    System.err.println("deliveryTag:" + envelope.getDeliveryTag());
                    // channel.basicAck(envelope.getDeliveryTag(), false);
                }
            };

            channel.basicConsume(QUEUE_NAME, consumer);
            // TimeUnit.SECONDS.sleep(10000000L);
        // }
    }
}