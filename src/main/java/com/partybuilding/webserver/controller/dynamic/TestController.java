package com.partybuilding.webserver.controller.dynamic;

import com.partybuilding.webserver.entity.message.MessageDTO;
import com.partybuilding.webserver.schedule.RabbitProduct;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@Api("")
public class TestController {
    @Resource
    private RabbitProduct rabbitConsultProduct;

    @ApiOperation("消息测试")
    @RequestMapping(value = "sendDeadLetterMSG",method = {RequestMethod.GET})
    public void sendDeadLetterMSG(Integer time){
        System.out.println(time);
        MessageDTO messageDTO = new MessageDTO();
//        messageDTO.setId(Uuid.getUuid());
//        messageDTO.setContent("你的身份认证已经通过，请查收");
//        messageDTO.setType("1");
        rabbitConsultProduct.sendDelayMessage(time,messageDTO);
    }

}
