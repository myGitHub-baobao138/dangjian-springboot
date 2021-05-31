package com.partybuilding.webserver.dao.system;


import com.partybuilding.webserver.dto.PermissionListDTO;
import com.partybuilding.webserver.entity.system.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SysPermissionMapper {

    List<PermissionListDTO> getPermission(@Param("organizationId") String organizationId, @Param("postId") String postId);

    List<PermissionListDTO> getAllPermissions();


    int deleteByPrimaryKey(String permissionId);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(String permissionId);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}