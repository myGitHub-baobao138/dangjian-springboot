package com.partybuilding.webserver.dto.system.right.showRight;

public class ResourceComponent {
    private String id; // 组件id
    private String pid; // pid
    private String label; // 组件名称

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
