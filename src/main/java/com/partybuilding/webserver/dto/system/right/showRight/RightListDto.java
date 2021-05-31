package com.partybuilding.webserver.dto.system.right.showRight;

import java.util.List;

/**
 * @author
 */
public class RightListDto {
    List<ResourceColumn> rightsList ; // 权限列表
    List<Object> hasRights; // 已有权限

    public List<ResourceColumn> getRightsList() {
        return rightsList;
    }

    public void setRightsList(List<ResourceColumn> rightsList) {
        this.rightsList = rightsList;
    }

    public List<Object> getHasRights() {
        return hasRights;
    }

    public void setHasRights(List<Object> hasRights) {
        this.hasRights = hasRights;
    }
}
