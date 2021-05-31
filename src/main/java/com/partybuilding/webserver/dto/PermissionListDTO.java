package com.partybuilding.webserver.dto;

import com.partybuilding.webserver.entity.system.SysPermission;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 菜单列表
 */
public class PermissionListDTO {
    private String permissionId;

    private String permissionName;

    private Integer permissionLevel;

    private String permissionPath;

    private String permissionUpId;

    private Integer order;

    private List<PermissionListDTO> children;

    public String getPermissionUpId() {
        return permissionUpId;
    }

    public void setPermissionUpId(String permissionUpId) {
        this.permissionUpId = permissionUpId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(Integer permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public String getPermissionPath() {
        return permissionPath;
    }

    public void setPermissionPath(String permissionPath) {
        this.permissionPath = permissionPath;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<PermissionListDTO> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionListDTO> children) {
        this.children = children;
    }
}
