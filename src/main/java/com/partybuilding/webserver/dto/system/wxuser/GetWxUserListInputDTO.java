package com.partybuilding.webserver.dto.system.wxuser;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 微信用户列表获取数据输入类
 */
public class GetWxUserListInputDTO {
    /**
     * 党员id
     */
    private String partyId;

    /**
     * 当前页
     */
    @NotNull(message = "当前页数不能为空")
    private Integer currentPage;

    /**
     * 每页数量
     */
    @NotNull(message = "每页数量不能为空")
    private Integer pageSize;

    /**
     * 微信昵称
     */
    private String nickname;

    /**
     * 是否认证 1-表示是 0-表示否
     */
    private Integer isAudited;

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getIsAudited() {
        return isAudited;
    }

    public void setIsAudited(Integer isAudited) {
        this.isAudited = isAudited;
    }
}
