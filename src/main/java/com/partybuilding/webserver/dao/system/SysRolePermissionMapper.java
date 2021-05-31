package com.partybuilding.webserver.dao.system;


import com.partybuilding.webserver.dto.UpdatePermissionInputDTO;
import com.partybuilding.webserver.entity.system.SysRolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysRolePermissionMapper {
    /**
     * 插入
     * @param sysRolePermission
     * @return
     */
    boolean insertRolePermissions(SysRolePermission sysRolePermission);

    /**
     * 删除
     * @param roleId
     * @return
     */
    boolean deleteByRoleId(String roleId);

    /**
     * 获取角色id
     * @param dto
     * @return
     */
    String getRoleIdByOrganizationIdPostId(UpdatePermissionInputDTO dto);



    int deleteByPrimaryKey(String rolePermissionId);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(String rolePermissionId);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}