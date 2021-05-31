package com.partybuilding.webserver.dao.service;


import com.partybuilding.webserver.dto.Organization;
import com.partybuilding.webserver.dto.service.leavewords.GetLeaveWordsInfoInputDTO;
import com.partybuilding.webserver.dto.service.leavewords.GetLeaveWordsQueryListInputDTO;
import com.partybuilding.webserver.dto.service.leavewords.LeaveWordsListDTO;
import com.partybuilding.webserver.dto.service.leavewords.ReplyLeaveWordsInputDTO;
import com.partybuilding.webserver.entity.service.ServiceLeaveWords;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */

@Mapper
@Repository
public interface ServiceLeaveWordsMapper {

    /**
     * 获取留言查询列表
     * @param dto
     * @return
     */
    List<LeaveWordsListDTO> getLeaveWordsQueryList(GetLeaveWordsQueryListInputDTO dto);

    /**
     * 查看留言信息
     * @param infoInputDTO
     * @return
     */
    LeaveWordsListDTO getLeaveWordInfo(GetLeaveWordsInfoInputDTO infoInputDTO);

    /**
     * 回复留言信息
     * @param inputDTO
     * @return
     */
    boolean replyLeaveWords(ReplyLeaveWordsInputDTO inputDTO);



    int deleteByPrimaryKey(String id);



    ServiceLeaveWords selectByPrimaryKey(String id);

    /**
     * 获取组织下拉框数据
     * @param id
     * @return
     */
    List<Organization> getOrganizationDownById(String id);


}