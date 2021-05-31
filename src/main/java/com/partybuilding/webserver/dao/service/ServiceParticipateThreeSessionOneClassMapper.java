package com.partybuilding.webserver.dao.service;


import com.partybuilding.webserver.entity.service.ServiceParticipateThreeSessionOneClass;

public interface ServiceParticipateThreeSessionOneClassMapper {
    int deleteByPrimaryKey(String id);

    int insert(ServiceParticipateThreeSessionOneClass record);

    int insertSelective(ServiceParticipateThreeSessionOneClass record);

    ServiceParticipateThreeSessionOneClass selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServiceParticipateThreeSessionOneClass record);

    int updateByPrimaryKey(ServiceParticipateThreeSessionOneClass record);
}