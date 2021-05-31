package com.partybuilding.webserver.dao.system;

import com.partybuilding.webserver.dto.role.RouterRoleDTO;
import com.partybuilding.webserver.dto.role.UserRoleDTO;
import com.partybuilding.webserver.dto.system.right.DeleteRightRoleAndResourceDTO;
import com.partybuilding.webserver.dto.system.right.FindRightBaseInfoDTO;
import com.partybuilding.webserver.dto.system.right.FindRightBaseInfoPageInfo;
import com.partybuilding.webserver.dto.system.right.allocateRight.AllocateRightRequest;
import com.partybuilding.webserver.dto.system.right.createRight.*;
import com.partybuilding.webserver.dto.system.right.showRight.ResourceColumn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysRightMapper {

    /**
     * 加载用户角色权限
     *
     * @param dto
     * @return
     */
    List<RouterRoleDTO> findUserRight(UserRoleDTO dto);

    /**
     * 查询权限基本信息
     *
     * @param dto
     * @return
     */
    List<FindRightBaseInfoDTO> findRightBaseInfo(FindRightBaseInfoPageInfo dto);

    /**
     * 删除权限角色及资源
     *
     * @param dto
     * @return
     */
    int deleteRightRoleAndResource(DeleteRightRoleAndResourceDTO dto);

    /**
     * 添加角色及其权限
     *
     * @param dto
     * @return
     */
    int addRole(CreateRightRequest dto);

    /**
     * 查询组织及其下面的职务
     *
     * @param dto
     * @return
     */
    List<OrganizationAndPostDTO> organizationAndPost(OrganizationAndPostRequestDTO dto);

    /**
     * 查询角色是否存在
     *
     * @param dto
     * @return
     */
    List<FindRightBaseInfoDTO> findRoleIsExist(FindOrganizationAndPostIsExist dto);

    /**
     * 查询角色已有权限
     *
     * @param dto
     * @return
     */
    List<ResourceColumn> findRightList(FindOrganizationAndPostIsExist dto);

    // 删除角色的权限
    int deleteRoleRight(AllocateRightRequest dto);

    /**
     * 分配角色权限
     *
     * @param dto
     * @return
     */
    int allocateRoleRight(AllocateRightRequest dto);

    /**
     * 通过组织和职务id查询角色id
     *
     * @param dto
     * @return
     */
    String findRoleId(FindOrganizationAndPostIsExist dto);
}
