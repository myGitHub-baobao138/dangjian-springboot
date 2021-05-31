package com.partybuilding.webserver.schedule;

import com.partybuilding.webserver.config.RabbitMQConfig;
import com.partybuilding.webserver.dao.MessageDao;
import com.partybuilding.webserver.dao.MessagePersonDao;
import com.partybuilding.webserver.entity.MessagePerson;
import com.partybuilding.webserver.entity.message.MessageDTO;
import com.partybuilding.webserver.util.Uuid;
import com.rabbitmq.client.Channel;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Version 1.0.0
 **/
@Component
@RabbitListener(queues = RabbitMQConfig.delay_queue) //监听此队列
public class RabbitConsultConsumer {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MessageDao messageDao;

    @Autowired
    MessagePersonDao messagePersonDao;
    /**
     * 定时消息队列消费监听回调
     * @param content 消息内容
     * @param message
     * @param channel 信道
     * @throws IOException
     */
    @RabbitHandler
    public void consultReceiveDealy(MessageDTO content, Message message, Channel channel) throws IOException {
        System.out.println(content.getMessageType());
        com.partybuilding.webserver.entity.Message message1 = new com.partybuilding.webserver.entity.Message();
        message1 = modelMapper.map(content, com.partybuilding.webserver.entity.Message.class);
        //添加消息时间
        message1.setMessagePublishTime(new Date());
        messageDao.insert(message1);
        List<String> personList = content.getMessageObjects();
        List<MessagePerson> messagePersonList = new LinkedList<>();
        for (int i = 0; i < personList.size(); i++) {
            MessagePerson messagePerson = new MessagePerson();
            messagePerson.setId(Uuid.getUuid());
            messagePerson.setPartyId(personList.get(i));
            messagePerson.setMessageId(message1.getId());
            messagePersonList.add(messagePerson);
        }
        messagePersonDao.insertAll(messagePersonList);
        //通知 MQ 消息已被接收,可以ACK(从队列中删除)了
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        try {
            System.out.println("=============Do Something==============");
        } catch (Exception e) {
            System.out.println("============消费失败,尝试消息补发再次消费!==============");
            System.out.println(e.getMessage());
            /**
             * basicRecover方法是进行补发操作，
             * 其中的参数如果为true是把消息退回到queue但是有可能被其它的consumer(集群)接收到，
             * 设置为false是只补发给当前的consumer
             */
            channel.basicRecover(false);
        }


    }
}

