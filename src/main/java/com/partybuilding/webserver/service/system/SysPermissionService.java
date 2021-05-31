package com.partybuilding.webserver.service.system;

import com.partybuilding.webserver.dto.PermissionListDTO;
import com.partybuilding.webserver.dto.UpdatePermissionInputDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public interface SysPermissionService {
    /**
     * 获取角色菜单栏列表
     * @param organizationId
     * @param postId
     * @return
     */
    List<PermissionListDTO> getPermissions(String organizationId, String postId);

    /**
     * 更新角色菜单栏列表
     * @param dto
     * @return
     */
    boolean updateRolePermissions(UpdatePermissionInputDTO dto);

    List<PermissionListDTO> getAllPermissions();
}
