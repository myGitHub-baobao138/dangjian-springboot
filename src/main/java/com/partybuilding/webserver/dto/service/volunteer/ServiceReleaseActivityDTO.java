package com.partybuilding.webserver.dto.service.volunteer;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * 发布活动
 */
public class ServiceReleaseActivityDTO {
    /**
     * 志愿活动id
     */
    private String id;

    /**
     * 发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date releaseTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public ServiceReleaseActivityDTO(String id, Date releaseTime) {
        this.id = id;
        this.releaseTime = releaseTime;
    }

    public ServiceReleaseActivityDTO() {
    }
}
