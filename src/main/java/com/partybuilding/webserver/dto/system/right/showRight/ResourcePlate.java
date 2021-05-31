package com.partybuilding.webserver.dto.system.right.showRight;

//import java.util.List;

public class ResourcePlate {
    private String id; // 板块id
    private String rightName; // 板块名称
    private String hasPermission; // 是否有权限

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    public String getHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(String hasPermission) {
        this.hasPermission = hasPermission;
    }
}
