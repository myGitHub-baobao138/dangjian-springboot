package com.partybuilding.webserver.dao.service;


import com.partybuilding.webserver.dto.service.themeDay.ThemeDayPartyMemberNumberDTO;
import com.partybuilding.webserver.dto.service.threeSessionOneClass.*;
import com.partybuilding.webserver.entity.service.ServiceParticipateThreeSessionOneClass;
import com.partybuilding.webserver.entity.service.ServiceThreeSessionOneClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ServiceThreeSessionOneClassMapper {
    int deleteByPrimaryKey(String id);

    int insert(ServiceThreeSessionOneClass record);

    int insertSelective(ServiceThreeSessionOneClass record);

    ServiceThreeSessionOneClass selectByPrimaryKey(String id);

    //    得到当前管理员可查看的所有三会一课 包含输入条件
    List<ThreeSessionOnClassDTO> getThreeSessionOneClassList(ThreeOneQueryDTO threeOneDTO);

    //  得到当前三会一课的详细信息
    ThreeSessionOnClassDTO getThreeOneDetail(String id);

    int updateByPrimaryKeySelective(ServiceThreeSessionOneClass record);

    int updateByPrimaryKeyWithBLOBs(ServiceThreeSessionOneClass record);

    int updateByPrimaryKey(ServiceThreeSessionOneClass record);

    //  删除三会一课
    int deleteThreeOne(String id);

    //  发布三会一课
    int postThreeOne(String[] ids);

    //  得到未参会人员表
    List<ParticipateReturnDTO> getNotAttendIdList(ParticipateDTO record);

    // 得到参会人员id
    List<String> getAttendIdList(String id);

    List<ParticipateReturnDTO> getPartyMemberListByOrganizationId(String organizationId);

    int insertAttendThreeOne(@Param("record") List<ServiceParticipateThreeSessionOneClass> record);

    int deleteParticipatesThreeOne(String threeOneId);

    List<ParticipateReturnDTO> getParticipateList(String threeOneId);
}