package xin.cymall.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by eyun003 on 2020/4/16.
 */
@Component
//监听队列kinson
@RabbitListener(queues = {"kinson"})
public class MyReceive {

    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("MyReceiver1 :" + msg);
    }
}