package com.partybuilding.webserver.dto.system.right.createRight;

import java.util.UUID;

public class RightsDTO {
    private String id; // 权限id
    private String columnId; // 栏目 id
    private String plateId; // 板块 id

    public RightsDTO(String columnId, String plateId) {
        this.id = UUID.randomUUID().toString().replaceAll("-","");
        this.columnId = columnId;
        this.plateId = plateId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public String getPlateId() {
        return plateId;
    }

    public void setPlateId(String plateId) {
        this.plateId = plateId;
    }
}
