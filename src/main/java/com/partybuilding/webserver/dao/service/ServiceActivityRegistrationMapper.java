package com.partybuilding.webserver.dao.service;


import com.partybuilding.webserver.dto.service.volunteer.InsertActivityDTO;
import com.partybuilding.webserver.dto.service.volunteer.SelectRegistrationDetailsDTO;
import com.partybuilding.webserver.entity.service.ServiceActivityRegistration;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author 包嵩
 * date:2019年12月26日
 */
@Mapper
public interface ServiceActivityRegistrationMapper {

    /**
     * 通过活动id查询活动报名信息
     * @param activityId
     * @return
     */
    List<SelectRegistrationDetailsDTO> selectInfoByActivityId(String activityId);

    /**
     * 添加活动信息
     * @param dto
     * @return
     */
    int insertActivity(InsertActivityDTO dto);
}