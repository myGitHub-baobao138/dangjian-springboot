package com.partybuilding.webserver.entity.system;

import java.util.Date;
/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 菜单类
 */


public class SysPermission {
    private String permissionId;

    private String permissionName;

    private String permissionUpId;

    private Integer permissionLevel;

    private String permissionPath;

    private Byte isDelete;

    private Date createTime;

    private Integer order;

    private Date updateTime;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionUpId() {
        return permissionUpId;
    }

    public void setPermissionUpId(String permissionUpId) {
        this.permissionUpId = permissionUpId == null ? null : permissionUpId.trim();
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
        this.permissionPath = permissionPath == null ? null : permissionPath.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}