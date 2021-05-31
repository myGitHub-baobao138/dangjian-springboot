package com.partybuilding.webserver.dao.system;

import com.partybuilding.webserver.dto.system.announcement.ResultAnnouncement;
import com.partybuilding.webserver.dto.system.announcement.TimeAndContentDto;
import com.partybuilding.webserver.entity.system.SysAnnouncement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface SysAnnouncementMapper {

    int insert(SysAnnouncement record);

    SysAnnouncement selectByPrimaryKey(String id);

//    List<SysAnnouncement> selectByContent(String content);
//
//    List<SysAnnouncement> selectByTime(Date publishTime);

    List<ResultAnnouncement> selectByTimeAndContent(TimeAndContentDto timeAndContentDto);

}