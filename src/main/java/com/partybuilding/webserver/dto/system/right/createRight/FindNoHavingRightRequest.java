package com.partybuilding.webserver.dto.system.right.createRight;

/**
 * 查询未有权限请求dto
 */
public class FindNoHavingRightRequest {
    private String columnIds;
    private String plateIds;
    private String  componentIds;

    public FindNoHavingRightRequest() {
    }

    public FindNoHavingRightRequest(String columnIds, String plateIds, String componentIds) {
        this.columnIds = columnIds;
        this.plateIds = plateIds;
        this.componentIds = componentIds;
    }

    public String getColumnIds() {
        return columnIds;
    }

    public void setColumnIds(String columnIds) {
        this.columnIds = columnIds;
    }

    public String getPlateIds() {
        return plateIds;
    }

    public void setPlateIds(String plateIds) {
        this.plateIds = plateIds;
    }

    public String getComponentIds() {
        return componentIds;
    }

    public void setComponentIds(String componentIds) {
        this.componentIds = componentIds;
    }
}
