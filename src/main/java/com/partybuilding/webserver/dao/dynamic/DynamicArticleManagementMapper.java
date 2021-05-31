package com.partybuilding.webserver.dao.dynamic;

import com.partybuilding.webserver.entity.dynamic.DynamicArticleManagement;

public interface DynamicArticleManagementMapper {
    int deleteByPrimaryKey(String id);

    int insert(DynamicArticleManagement record);

    int insertSelective(DynamicArticleManagement record);

    DynamicArticleManagement selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DynamicArticleManagement record);

    int updateByPrimaryKeyWithBLOBs(DynamicArticleManagement record);

    int updateByPrimaryKey(DynamicArticleManagement record);
}