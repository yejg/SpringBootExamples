package io.ymq.rabbitmq.test.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Procuder {
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

        // 1.队列名称
        // 2.消息是否持久化
        // 3.当前消息队列是否属于当前连接对象独有（一般是false）
        // 4.在消息使用完毕之后，是否删除该消息
        // 5.附加参数
        channel.queueDeclare("test",true,false,false,null);

        /**
         * basicPublish(String exchange, String routingKey, BasicProperties props, byte[] body)
         * exchange:指定交换机 不指定 则默认 （AMQP default交换机）
         * routingKey：通过routingkey进行匹配
         * props:消息属性
         * body:消息体
         */
        //4.通过Channel发送数据
        for (int i = 0; i < 5; i++) {
            System.out.println("生产消息:" + i);
            String msg = "Hello RabbitMQ" + i;
            channel.basicPublish("", "test", null, msg.getBytes());
        }

        //5.记得关闭相关的连接
        channel.close();
        connection.close();
    }
}