package xin.cymall.common.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xin.cymall.common.log.LogUtil;

import java.text.MessageFormat;


/**
 * Created by eyun003 on 2020/4/16.
 */

@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue kinsonQueue() {
        return new Queue("kinson");
    }

    // 获取连接工厂
    @Bean
    public ConnectionFactory factory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        return factory;
     }

    @Bean
    public RabbitTemplate rabbitTemplate() {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory());

        // 消息发送失败返回到队列中, yml需要配置 publisher-returns: true
        rabbitTemplate.setMandatory(true);

        // 消息返回, yml需要配置 publisher-returns: true
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            String correlationId = message.getMessageProperties().getCorrelationIdString();
            LogUtil.info(MessageFormat.format("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey));
        });

        // 消息确认, yml需要配置 publisher-confirms: true
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                LogUtil.info(MessageFormat.format("消息发送到exchange成功,id: {}", correlationData.getId()));
            } else {
                LogUtil.info(MessageFormat.format("消息发送到exchange失败,原因: {}", cause));
            }
        });

        return rabbitTemplate;
    }

}
