package com.partybuilding.webserver.dao.service;

import com.partybuilding.webserver.entity.service.ServiceAnswerDetails;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ServiceAnswerDetailsMapper {
    int deleteByPrimaryKey(String id);

    int insert(ServiceAnswerDetails record);

    int insertSelective(ServiceAnswerDetails record);

    ServiceAnswerDetails selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServiceAnswerDetails record);

    int updateByPrimaryKey(ServiceAnswerDetails record);
}