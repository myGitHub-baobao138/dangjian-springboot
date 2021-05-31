package com.partybuilding.webserver.service.service;

import com.partybuilding.webserver.dto.service.changeOrganization.FindChangeOrganizationInfoPageDTO;
import com.partybuilding.webserver.dto.service.changeOrganization.OrganizationApplicationRequestDTO;
import com.partybuilding.webserver.dto.service.changeOrganization.OrganizationApprovalHistory;
import com.partybuilding.webserver.dto.service.changeOrganization.OriginAndTargetOrganizationDTO;
import com.partybuilding.webserver.entity.service.ServiceChangeOrganizationApproval;
import com.partybuilding.webserver.util.PageResult;

import java.util.List;

public interface ServiceChangeOrganizationService {
    /**
     * 创建转组织关系申请
     * @param dto
     * @return
     */
    int createChangeOrganizationRelationshipApplication(OrganizationApplicationRequestDTO dto);

    /**
     * 创建转组织关系申请时，通过学号/工号查询源组织与目的组织
     * @param number
     * @return
     */
    OriginAndTargetOrganizationDTO searchOrganizationByNum(String number);

    /**
     *查询转组织关系申请
     * @param dto
     * @return
     */
    PageResult findChangeOrganizationByCondition(FindChangeOrganizationInfoPageDTO dto);

    /**
     * 查询审核历史
     * @param applicationId
     * @return
     */
    List<OrganizationApprovalHistory> findApprovalHistory(String applicationId);

    /**
     * 审批确认并添加一条审核历史记录
     * @param dto
     * @return
     */
    int addApprovalRecord(ServiceChangeOrganizationApproval dto);

    /**
     * 状态完成时查看审批状态
     * @param applicationId
     * @return
     */
    int findApplicationState(String applicationId);
}
