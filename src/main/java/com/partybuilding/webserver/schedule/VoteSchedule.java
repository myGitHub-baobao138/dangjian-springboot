package com.partybuilding.webserver.schedule;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 */
@Component
public class VoteSchedule {
    @Autowired
    RedisTemplate redisTemplate;

//    @Scheduled(cron = "0  */10  *  *  *  ?")
//    public void setSet() throws ParseException {
//        ZSetOperations set = redisTemplate.opsForZSet();
//        System.out.println( set.toString());
//    }
}
