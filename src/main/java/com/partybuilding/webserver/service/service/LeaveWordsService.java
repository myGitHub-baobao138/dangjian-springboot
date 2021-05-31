package com.partybuilding.webserver.service.service;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.Organization;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.service.leavewords.GetLeaveWordsInfoInputDTO;
import com.partybuilding.webserver.dto.service.leavewords.GetLeaveWordsQueryListInputDTO;
import com.partybuilding.webserver.dto.service.leavewords.LeaveWordsListDTO;
import com.partybuilding.webserver.dto.service.leavewords.ReplyLeaveWordsInputDTO;
import com.partybuilding.webserver.util.PageResult;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */


public interface LeaveWordsService {


    /**
     * 获取留言查询列表
     * @param dto
     * @return
     */
    PageResult<LeaveWordsListDTO> getLeaveWordsQueryList(GetLeaveWordsQueryListInputDTO dto);


    /**
     * 查询留言信息
     * @param infoInputDTO
     * @return
     */
    LeaveWordsListDTO getLeaveWordsInfo(GetLeaveWordsInfoInputDTO infoInputDTO);

    /**
     * 回复留言
     * @param inputDTO
     * @return
     */
    JsonResult replyLeaveWords(ReplyLeaveWordsInputDTO inputDTO);


    /**
     * 获取组织下拉框数据
     * @param id
     * @return
     */
    List<Organization> getOrganizationDownById(String id);

}
