package com.partybuilding.webserver.dao.system;

import com.partybuilding.webserver.entity.system.SysUserAnnouncement;

public interface SysUserAnnouncementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserAnnouncement record);

    int insertSelective(SysUserAnnouncement record);

    SysUserAnnouncement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserAnnouncement record);

    int updateByPrimaryKey(SysUserAnnouncement record);
}