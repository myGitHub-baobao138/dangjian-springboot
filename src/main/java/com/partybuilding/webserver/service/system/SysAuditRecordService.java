package com.partybuilding.webserver.service.system;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.Organization;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.system.academy.GetAcademyQueryListInputDTO;
import com.partybuilding.webserver.dto.system.auditRecord.*;
import com.partybuilding.webserver.util.PageResult;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public interface SysAuditRecordService {


    /**
     * 获取认证信息详情
     * @param id
     * @return
     */
    GetVerificationInfoDTO getVerificationInfo(String id);

    /**
     * 微信用户审核
     * @param inputDTO
     * @return
     */
    JsonResult verifyWxUser(VerifyWxUserInputDTO inputDTO);

    /**
     * 获取认证信息查询列表
     * @param inputDTO
     * @return
     */
    PageResult<GetVerificationInfoListDTO> getVerificationInfoQueryList(GetVerificationInfoQueryListInputDTO inputDTO);

    /**
     * 获取组织下拉框数据
     * @param id
     * @return
     */
    List<Organization> getOrganizationDownById(String id);

    /**
     * 批量审核
     * @param inputListDTO
     * @return
     */
    JsonResult verifyWxUserList(VerifyWxUserInputListDTO inputListDTO);
}
