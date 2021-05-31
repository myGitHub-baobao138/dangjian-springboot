package com.partybuilding.webserver.dto.service.question;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


/**
 * 发布考题
 */
public class ReleaseExamineDTO {
    /**
     * 考题id
     */
    private List<String> id;

    /**
     * 发布时间
     */
    private String releaseTime;

    public List<String> getId() {
        return id;
    }

    public void setId(List<String> id) {
        this.id = id;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }
}
