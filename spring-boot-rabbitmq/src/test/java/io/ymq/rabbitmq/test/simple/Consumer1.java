package io.ymq.rabbitmq.test.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class Consumer1 {
    public static void main(String[] args) throws Exception {
        //1.创建一个ConnectionFactory 并进行配置
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setHandshakeTimeout(20000);
        //2.通过连接工厂创建连接
        Connection connection = connectionFactory.newConnection();

        //3.通过Connection 创建一个 Channel
        Channel channel = connection.createChannel();

        //4. 声明创建一个队列
        String queueName = "test";
        /**
         * durable 是否持久化
         * exclusive 独占的  相当于加了一把锁
         */
        channel.queueDeclare(queueName, true, false, false, null);

        //5.创建消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        //6.设置channel
        /**
         * ACK: 当一条消息从生产端发到消费端，消费端接收到消息后会马上回送一个ACK信息给broker,告诉它这条消息收到了
         * autoack:
         * true  自动签收 当消费者一收到消息就表示消费者收到了消息，消费者收到了消息就会立即从队列中删除。
         * false 手动签收 当消费者收到消息在合适的时候来显示的进行确认，说我已经接收到了该消息了，RabbitMQ可以从队列中删除该消息了
         *
         */
        channel.basicConsume(queueName, true, queueingConsumer);

        //7.获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String msg = new String(delivery.getBody());
            System.err.println("消费端1:" + msg);
            //Envelope envelope = delivery.getEnvelope();
        }
    }
}


/*
QueueingConsumer 不推荐使用了。
原因是：1、QueueingConsumer会拖累Connection的所有Channels的操作；2、同步递归调用时会产生死锁
See：https://blog.csdn.net/u013256816/article/details/71342622





*/