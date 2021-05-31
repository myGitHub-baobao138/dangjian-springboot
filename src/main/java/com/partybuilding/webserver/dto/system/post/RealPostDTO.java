package com.partybuilding.webserver.dto.system.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

/**
 * 添加或修改职务实际数据 dto
 */
public class RealPostDTO {
    private String id; // 职务 id
    private String name; // 职务名称
    private String partyId; // 党员 id
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    private String createTime; // 创建时间
    private Integer rank; // 等级

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
