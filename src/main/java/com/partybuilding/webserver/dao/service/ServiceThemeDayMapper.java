package com.partybuilding.webserver.dao.service;

import com.partybuilding.webserver.dto.service.themeDay.ThemeDayDetailsDTO;
import com.partybuilding.webserver.dto.service.themeDay.ThemeDayPartyMemberNumberDTO;
import com.partybuilding.webserver.dto.service.themeDay.ThemeDayQueryDTO;
import com.partybuilding.webserver.dto.service.themeDay.ThemeDayTableDto;
import com.partybuilding.webserver.dto.service.threeSessionOneClass.ParticipateReturnDTO;
import com.partybuilding.webserver.entity.service.ServiceThemeDay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ServiceThemeDayMapper {
    int deleteByPrimaryKey(String id);

    int insert(ServiceThemeDay record);

    int insertSelective(ServiceThemeDay record);

    ServiceThemeDay selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServiceThemeDay record);

    int updateByPrimaryKey(ServiceThemeDay record);
//  得到表格所需数据
    List<ThemeDayTableDto> getThemeDayTableList(ThemeDayQueryDTO record);
//  查看详情
    ThemeDayDetailsDTO getThemeDayDetails(String id);
//  删除党主题日，status = -1
    int deleteThemeDay(String id);
//  status=0 --> status=1
    int postThemeDay(String[] ids);
//   置顶
    int updateTop(String id);
//    取消置顶
    int updateNotTop(String id);
//    得到默认的组织名称、支部书记、书记的电话
    ThemeDayDetailsDTO getInsertThemeDayDefaultThree(String organizationId);
//    得到当前下的所有党员数
    int getPartyMemberNumber(ThemeDayPartyMemberNumberDTO record);
//    得到参会人员id
    String getAttendThemeDayPartyIdList(String id);
//    得到参会人员id与姓名
    List<ParticipateReturnDTO> getAttendThemeDayPartyList(String id);

}