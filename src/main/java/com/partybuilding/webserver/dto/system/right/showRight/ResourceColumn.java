package com.partybuilding.webserver.dto.system.right.showRight;

import java.util.List;

public class ResourceColumn {
    private String id; // 栏目 id
    private String rightName;  // 栏目名称
    List<ResourcePlate> children; // 组件 list

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

    public List<ResourcePlate> getChildren() {
        return children;
    }

    public void setChildren(List<ResourcePlate> children) {
        this.children = children;
    }
}
