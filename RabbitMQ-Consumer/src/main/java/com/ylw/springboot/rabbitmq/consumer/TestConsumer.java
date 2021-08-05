package com.ylw.springboot.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TestConsumer {

    @RabbitListener(queues = "test_queue")
    public void process(Message message, @Headers Map<String, Object> headers, Channel channel) throws Exception {
        String messageId = message.getMessageProperties().getMessageId();
        String msg = new String(message.getBody(), "UTF-8");
        System.out.println("死信邮件消费者获取生产者消息msg:" + msg + ",消息id:" + messageId);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

}