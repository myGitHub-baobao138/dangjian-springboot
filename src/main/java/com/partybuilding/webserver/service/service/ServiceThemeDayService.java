package com.partybuilding.webserver.service.service;

import com.partybuilding.webserver.dto.service.themeDay.ThemeDayDetailsDTO;
import com.partybuilding.webserver.dto.service.themeDay.ThemeDayPartyMemberNumberDTO;
import com.partybuilding.webserver.dto.service.themeDay.ThemeDayQueryDTO;
import com.partybuilding.webserver.dto.service.themeDay.ThemeDayTableDto;
import com.partybuilding.webserver.dto.service.threeSessionOneClass.ParticipateReturnDTO;
import com.partybuilding.webserver.entity.service.ServiceThemeDay;
import com.partybuilding.webserver.util.PageResult;

import java.util.List;

public interface ServiceThemeDayService {
    int deleteByPrimaryKey(String id);

    int insert(ServiceThemeDay record);

    int insertSelective(ServiceThemeDay record);

    ServiceThemeDay selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServiceThemeDay record);

    int updateByPrimaryKey(ServiceThemeDay record);

    PageResult<ThemeDayTableDto> getThemeDayTableList(ThemeDayQueryDTO record);

    ThemeDayDetailsDTO getThemeDayDetails(String id);

    int deleteThemeDay(String id);

    int postThemeDay(String[] ids);

    int updateTop(String id);

    int updateNotTop(String id);

    ThemeDayDetailsDTO getInsertThemeDayDefaultThree(String organizationId);

    int getPartyMemberNumber(ThemeDayPartyMemberNumberDTO record);

    String getAttendThemeDayPartyIdList(String id);

    List<ParticipateReturnDTO> getAttendThemeDayPartyList(String id);
}
