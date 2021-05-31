package com.partybuilding.webserver.dao.dynamic;

import com.partybuilding.webserver.entity.dynamic.DynamicPraiseRecord;

public interface DynamicPraiseRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(DynamicPraiseRecord record);

    int insertSelective(DynamicPraiseRecord record);

    DynamicPraiseRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DynamicPraiseRecord record);

    int updateByPrimaryKey(DynamicPraiseRecord record);
}