package com.partybuilding.webserver.schedule;

import com.partybuilding.webserver.config.RabbitMQConfig;
import com.partybuilding.webserver.entity.message.MessageDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName RabbitProduct
 * @Version 1.0.0
 **/
@Component
public class RabbitProduct {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendDelayMessage(long time,MessageDTO content){
        this.rabbitTemplate.convertAndSend(RabbitMQConfig.delay_exchange,RabbitMQConfig.delay_routing_key,content, message -> {
                //注意这里时间可以使long，而且是设置header
                message.getMessageProperties().setHeader("x-delay",time);
                return message;
            }
        );
    }

}

