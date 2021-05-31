package com.partybuilding.webserver.dto.system.post;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 添加或修改职务请求数据 dto
 */
public class ReqPostDTO {
    @NotEmpty(message = "职务名称不能为空")
    private String name; // 职务名称
    @NotEmpty(message = "党员id不能为空")
    private String partyId; // 党员 id
    @NotNull(message = "职务等级不能为空")
    private Integer rank; // 等级

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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
