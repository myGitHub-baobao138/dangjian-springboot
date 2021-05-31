package com.partybuilding.webserver.service.system;

import com.partybuilding.webserver.dto.role.RouterRoleDTO;
import com.partybuilding.webserver.dto.role.UserRoleDTO;
import com.partybuilding.webserver.dto.system.right.DeleteRightRoleAndResourceDTO;
import com.partybuilding.webserver.dto.system.right.FindRightBaseInfoPageInfo;
import com.partybuilding.webserver.dto.system.right.allocateRight.AllocateRightRequest;
import com.partybuilding.webserver.dto.system.right.createRight.CreateRightRequest;
import com.partybuilding.webserver.dto.system.right.createRight.FindOrganizationAndPostIsExist;
import com.partybuilding.webserver.dto.system.right.createRight.OrganizationAndPostDTO;
import com.partybuilding.webserver.dto.system.right.createRight.OrganizationAndPostRequestDTO;
import com.partybuilding.webserver.dto.system.right.showRight.RightListDto;
import com.partybuilding.webserver.util.PageResult;

import java.util.List;

public interface SysRightService {
    /**
     * 加载用户角色权限
     *
     * @param dto
     * @return
     */
    List<RouterRoleDTO> findUserRight(UserRoleDTO dto);

    /**
     * 查询权限基本信息
     * @param dto
     * @return
     */
    PageResult findRightBaseInfo(FindRightBaseInfoPageInfo dto);

    /**
     * 删除权限角色及资源
     * @param dto
     * @return
     */
    int deleteRightRoleAndResource(DeleteRightRoleAndResourceDTO dto);

    /**
     * 创建权限
     * @param dto
     * @return
     */
    int createRightInfo(CreateRightRequest dto);

    /**
     * 查询组织及其下面的职务
     * @return
     * @param dto
     */
    List<OrganizationAndPostDTO> organizationAndPost(OrganizationAndPostRequestDTO dto);

    /**
     * 查询角色已有权限
     * @param dto
     * @return
     */
    RightListDto findRightList(FindOrganizationAndPostIsExist dto);

    /**
     * 分配角色权限
     *
     * @param dto
     * @return
     */
    int allocateRoleRight(AllocateRightRequest dto);
}
