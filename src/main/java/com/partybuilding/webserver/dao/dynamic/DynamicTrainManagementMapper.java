package com.partybuilding.webserver.dao.dynamic;

import com.partybuilding.webserver.entity.dynamic.DynamicTrainManagement;

public interface DynamicTrainManagementMapper {
    int deleteByPrimaryKey(String id);

    int insert(DynamicTrainManagement record);

    int insertSelective(DynamicTrainManagement record);

    DynamicTrainManagement selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DynamicTrainManagement record);

    int updateByPrimaryKeyWithBLOBs(DynamicTrainManagement record);

    int updateByPrimaryKey(DynamicTrainManagement record);
}