package com.partybuilding.webserver.dao.service;

import com.partybuilding.webserver.dto.service.changeOrganization.*;
import com.partybuilding.webserver.entity.service.ServiceChangeOrganization;
import com.partybuilding.webserver.entity.service.ServiceChangeOrganizationApproval;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ServiceChangeOrganizationMapper {
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
    List<ServiceChangeOrganization> findChangeOrganizationByCondition(FindChangeOrganizationInfoPageDTO dto);

    /**
     * 查询党支部是否存在
     * @param organizationName
     * @return
     */
    String findOriginOrganizationIsExist(String organizationName);

    /**
     * 查询党员是否在该支部中
     * @param dto
     * @return
     */
    String findPartyIsExistOnOriginOrganization(FindPartyIsExistOnOriginOrganizationDTO dto);

    /**
     * 查询审核历史
     * @param applicationId
     * @return
     */
    List<OrganizationApprovalHistory>findApprovalHistory(String applicationId);

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
    String findApplicationState(String applicationId);
}