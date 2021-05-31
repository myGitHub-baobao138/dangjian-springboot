package com.partybuilding.webserver.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 */
//@Configuration
public class RabbitMQConfig {
    //定义延迟队列
    public static final String delay_queue = "delay_queue";
    //定义延迟交换机
    public static final String delay_exchange = "delay_exchange";
    //定义路由键
    public static final String delay_routing_key = "delay_routing_key";
    //定义死信队列
    public static final String delay_dead = "delay_dead";
    //定义死信交换机
    public static final String delay_dead_exchange = "delay_dead_exchange";
    //定义死信路由建
    public static final String delay_dead_routing_key = "delay_dead_routing_key";

    /**
     * 定义延迟队列
     * @return
     */
    @Bean
    public Queue delayQueue(){
        return new Queue(delay_queue,true);
    }



    /**
     * 延时队列交换机
     * 交换机类型：CustomExchange
     * @return
     */
    @Bean
    public CustomExchange delayExchange(){
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(delay_exchange,"x-delayed-message",true, false, args);
    }

    /**
     * 为延迟队列绑定交换机
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding delayBinding(Queue queue, CustomExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(delay_routing_key).noargs();
    }
}
