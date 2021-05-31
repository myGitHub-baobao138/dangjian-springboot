package com.partybuilding.webserver.config;

import com.partybuilding.webserver.entity.system.SysOrganizationalStructure;
import com.partybuilding.webserver.service.service.ServiceVolunteerActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 */
@Component
public class Timer {
    @Autowired
    ServiceVolunteerActivityService serviceVolunteerActivityService;

    /**改变志愿活动状态 每分钟执行一次*/
    @Scheduled(cron = "0  */1  *  *  *  ?")
    public void timeTask1() throws ParseException {
        //精确到分钟
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
        //活动报名截止时间
        Date beginTime1 = new Date();
        String result1=formatter.format(beginTime1);
        Date newBeginTime1 = formatter.parse(result1);
        //当前这一分钟内
        Date endTime1 = new Date(newBeginTime1.getTime()+1000*60);
        List<Date> list1 = serviceVolunteerActivityService.getRegistrationDeadline(newBeginTime1,endTime1);
        if(list1 != null){
            for(int i = 0; i<list1.size(); i++){
                //修改活动状态为报名截止
                serviceVolunteerActivityService.changeStateToDeadline(list1.get(i));
            }
        }
        //活动结束时间
        Date beginTime2 = new Date();
        String result2=formatter.format(beginTime2);
        Date newBeginTime2 = formatter.parse(result2);
        Date endTime2 = new Date(newBeginTime2.getTime()+1000*60);
        List<Date> list2 = serviceVolunteerActivityService.getEndTime(newBeginTime2,endTime2);
        if(list2 != null){
            for(int i = 0; i<list2.size(); i++){
                //修改活动状态为活动结束
                serviceVolunteerActivityService.changeStateToEnd(list2.get(i));
            }
        }
    }
}
