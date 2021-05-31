package com.partybuilding.webserver.service.service;

import com.partybuilding.webserver.dto.service.themeDay.ThemeDayPartyMemberNumberDTO;
import com.partybuilding.webserver.dto.service.threeSessionOneClass.*;
import com.partybuilding.webserver.entity.service.ServiceParticipateThreeSessionOneClass;
import com.partybuilding.webserver.entity.service.ServiceThreeSessionOneClass;
import com.partybuilding.webserver.util.PageResult;

import java.util.List;

public interface ServiceThreeSessionOneClassService {
    int deleteByPrimaryKey(String id);

    int insert(ServiceThreeSessionOneClass record);

    int insertSelective(ServiceThreeSessionOneClass record);

    ServiceThreeSessionOneClass selectByPrimaryKey(String id);

    //  删除三会一课
    int deleteThreeOne(String id);
    //  发布三会一课
    int postThreeOne(String[] ids);

//    得到当前管理员可查看的所有三会一课
    PageResult<ThreeSessionOnClassDTO> getThreeSessionOneClassList(ThreeOneQueryDTO threeOneDTO);

    //    得到会议的详细信息，主要是查到参会人员的名字。
    ThreeSessionOnClassDTO getThreeOneDetail(String id);

    List<ParticipateReturnDTO> getNotAttendIdList(ParticipateDTO record);

    List<String> getAttendIdList(String id);

    int updateByPrimaryKeySelective(ServiceThreeSessionOneClass record);

    int updateByPrimaryKeyWithBLOBs(ServiceThreeSessionOneClass record);

    int updateByPrimaryKey(ServiceThreeSessionOneClass record);

    List<ParticipateReturnDTO> getPartyMemberListByOrganizationId(String organizationId);
//增加中间的信息
    int insertAttendThreeOne(List<ServiceParticipateThreeSessionOneClass> record);
//删除参会人员中间表
    int deleteParticipatesThreeOne(String threeOneId);


    List<ParticipateReturnDTO> getParticipateList(String threeOneId);
}
