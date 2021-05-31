package com.partybuilding.webserver.config;

import com.partybuilding.webserver.entity.service.ServiceExaminationManagement;
import com.partybuilding.webserver.service.service.ServiceExamineManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *

 * @Description:
 */

@Configuration //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling // 2.开启定时任务
public class SimpleScheduleConfig {
    @Autowired
    private ServiceExamineManagementService serviceExamineManagementService;

    //3.添加定时任务半小时
    @Scheduled(cron = "0 0/30 * * * ?")
    private void configureTasks() {
        List<ServiceExaminationManagement>  list = serviceExamineManagementService.selectAllExamineQuestion();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(new Date());
        Date now = new Date();
        for(ServiceExaminationManagement serviceExaminationManagement:list){
            if(today.equals(serviceExaminationManagement.getStart()) || now.getTime() > serviceExaminationManagement.getBeginTime().getTime()){ // 已开始
                if(serviceExaminationManagement.getState() == 2){
                    serviceExamineManagementService.updateState(3,serviceExaminationManagement.getId());
                }
            }
            if(now.getTime() >= tomorrow(serviceExaminationManagement.getEndTime()).getTime()){ // 已结束
                if(serviceExaminationManagement.getState() == 3){
                    serviceExamineManagementService.updateState(4,serviceExaminationManagement.getId());
                }
            }


        }

    }

    /**
     * 返回明天
     * @param today
     * @return
     */
    public Date tomorrow(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
        return calendar.getTime();
    }



}
