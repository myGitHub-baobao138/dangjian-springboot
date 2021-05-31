package com.partybuilding.webserver.dao.system;

import com.partybuilding.webserver.entity.system.WxUserCollect;

public interface WxUserCollectMapper {
    int deleteByPrimaryKey(String id);

    int insert(WxUserCollect record);

    int insertSelective(WxUserCollect record);

    WxUserCollect selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WxUserCollect record);

    int updateByPrimaryKey(WxUserCollect record);
}