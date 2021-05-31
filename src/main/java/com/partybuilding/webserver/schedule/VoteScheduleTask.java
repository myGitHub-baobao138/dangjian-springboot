package com.partybuilding.webserver.schedule;

import com.partybuilding.webserver.dao.service.ServiceVoteMapper;
import com.partybuilding.webserver.dao.system.SysOrganizationalStructureMapper;
import com.partybuilding.webserver.dao.system.SysPartyMemberInformationMapper;
import com.partybuilding.webserver.dto.service.voteDto.EndTimeAndId;
import com.partybuilding.webserver.entity.message.MessageDTO;
import com.partybuilding.webserver.util.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *投票调查定时任务
 */
@Component
@EnableScheduling  //开启定时任务
@EnableAsync //开启多线程
public class VoteScheduleTask {
    @Autowired
    private SysOrganizationalStructureMapper structureMapper;
    @Autowired
    SysPartyMemberInformationMapper partyMapper;


    @Autowired
    ServiceVoteMapper serviceVoteMapper;

    @Autowired
    private RabbitProduct rabbitConsultProduct;

    @Scheduled(cron = "0  */1  *  *  *  ?")
    public void updateStatus(){
        //变更为结束状态
        List<EndTimeAndId> endTimeAndIdList = serviceVoteMapper.getStatusAndTime();

        long getTime = Long.valueOf(getTime().replaceAll("-","").replaceAll(":","").replaceAll(" ",""));


        for (EndTimeAndId endTimeAndId :endTimeAndIdList) {

            long endTime = Long.valueOf(endTimeAndId.getTime().substring(0,endTimeAndId.getTime().length()-3).replaceAll("-","").replaceAll(":","").replaceAll(" ",""));

            System.out.println(endTime);
            System.out.println(endTime+"----"+getTime);
            if (getTime>=endTime){
                serviceVoteMapper.updateStatus(endTimeAndId.getId(),-1);
            }
        }

        //变更为进行中的状态
        List<EndTimeAndId> beginTimeList = serviceVoteMapper.getBeginTime();
        for (EndTimeAndId beginTime:beginTimeList) {
            long beginTimes = Long.valueOf(beginTime.getTime().substring(0,beginTime.getTime().length()-3).replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
            if (getTime>=beginTimes){
                serviceVoteMapper.updateStatus(beginTime.getId(),1);
                sendMessage(beginTime);
            }
        }

    }
    public String getTime(){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(date);

        return time.substring(0,time.length()-3);
    }

    public void sendMessage(EndTimeAndId endTimeAndId){
        Integer rank = structureMapper.selectRank(endTimeAndId.getOrganizationId());
        List<String> partyList = new LinkedList<>();
        //根据管理员等级查找该组织下面的党员id
        if (rank>1){
            //二级组织及以下
            partyList = partyMapper.selectPartyByOrganizationId(endTimeAndId.getOrganizationId());
        }else {
            //一级组织
            partyList = partyMapper.selectAllPartyByOrganizationId(endTimeAndId.getOrganizationId());
        }
        //获取消息通知人的id
        //发送消息
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setMessageType("1");
        messageDTO.setMessageTitle("投票调查开始通知");
        messageDTO.setMessageContent("您有投票调查已经开始，请抓紧时间前往投票，投票时间"+
                endTimeAndId.getTime()+"-----"+endTimeAndId.getEndTime());
        messageDTO.setId(Uuid.getUuid());
        messageDTO.setMessageObjects(partyList);
        messageDTO.setPartyId(endTimeAndId.getPartyId());
        //消息开始
        long time = 1000;
        rabbitConsultProduct.sendDelayMessage(time,messageDTO);

    }
}
